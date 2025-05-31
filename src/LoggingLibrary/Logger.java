package LoggingLibrary;

import LoggingLibrary.appender.Appender;
import LoggingLibrary.appender.ConsoleAppender;
import LoggingLibrary.appender.DBAppender;
import LoggingLibrary.appender.FileAppender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Logger {

    public final List<Appender> appenders=new ArrayList<>();
    String appName;
    public ExecutorService executorService= Executors.newFixedThreadPool(4);

    public Logger()
    {
        loadLogger();
    }
    public void loadLogger()
    {
        Gson gson = new Gson();
        try {
            List<LoggerConfig> configs = gson.fromJson(new FileReader("logger.json"),
                    new TypeToken<List<LoggerConfig>>() {}.getType());

            for (LoggerConfig config : configs) {
                for (String levelStr : config.logLevels) {
                    LoggerLevel level = LoggerLevel.valueOf(levelStr.toUpperCase());

                    switch (config.target.toLowerCase()) {
                        case "file":
                            appenders.add(new FileAppender(level, config.fileLocation, config.async));
                            break;
                        case "db":
                            appenders.add(new DBAppender(level, config.endpoint,  config.async , config.port));
                            break;
                        default:
                            System.err.println("Unknown target: " + config.target);
                    }
                }
                this.appName = config.appName != null ? config.appName : "MyApp";
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load logger.json", e);
        }
    }

    public void info(String message)
    {
            LogMessage logMessage=new LogMessage();
            logMessage.message=message;
            check(LoggerLevel.INFO,logMessage);
    }

    public void check(LoggerLevel loggerLevel,LogMessage logMessage)
    {

        for(Appender appender:appenders)
        {

            if(appender.getLevel().equals(loggerLevel))
            {
                if(appender.isSync())
                {
                   executorService.submit(() -> appender.append(logMessage) );
                }
                else{
                    appender.append(logMessage);
                }

            }
        }
    }
}


