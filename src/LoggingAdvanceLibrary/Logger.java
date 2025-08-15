package LoggingAdvanceLibrary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import LoggingAdvanceLibrary.Logs.LogTarget;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class Logger {

    HashMap<LogLevel,List<LogTarget>> map=new HashMap<>();
    List<LogConfig> loadCofigs;
    public Logger(boolean isSync)
    {
        try {
            Class.forName("LoggingAdvanceLibrary.Logs.PrintLog");
            Class.forName("LoggingAdvanceLibrary.Logs.DbLog");
            // same for other targets: DbLogTarget, UrlLogTarget, etc.
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        loadConfig();
    }

    public void loadConfig()
    {
        try{
            FileReader fileReader = new FileReader("C:\\Users\\91955\\Downloads\\logger.json");
            Type listType=new TypeToken<List<LogConfig>>(){}.getType();
            loadCofigs=new Gson().fromJson(fileReader,listType);

            for(LogConfig logConfig:loadCofigs)
            {
                LogTarget logTarget=LogFactory.create(logConfig);
                map.computeIfAbsent(LogLevel.valueOf(logConfig.logLevel.toUpperCase()),
                        k -> new ArrayList<>()).add(logTarget);

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void log(LogLevel logLevel,String message)
    {
       List<LogTarget> logtargets=map.get(logLevel);
        for(LogTarget logaTarget:logtargets)
        {
           logaTarget.log(message);
        }
    }


    public void info(String message) { log(LogLevel.INFO, message); }
    public void debug(String message) { log(LogLevel.DEBUG, message); }
    public void warn(String message) { log(LogLevel.WARN, message); }
    public void error(String message) { log(LogLevel.ERROR, message); }
}
