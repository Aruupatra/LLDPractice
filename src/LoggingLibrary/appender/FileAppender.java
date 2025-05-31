package LoggingLibrary.appender;

import LoggingLibrary.LogMessage;
import LoggingLibrary.LoggerLevel;

import java.util.Set;

public class FileAppender implements Appender{

    LoggerLevel loggerLevel;
    String filePath;
    boolean isSync;
    public FileAppender(LoggerLevel loggerLevel,String filePath,boolean isSync)
    {
        this.loggerLevel=loggerLevel;
        this.filePath=filePath;
        this.isSync=isSync;
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println("FileAppender -> "+logMessage.getMessage());
    }

    @Override
    public boolean isSync() {
        return isSync;
    }


    public LoggerLevel getLevel() {
        return this.loggerLevel;
    }
}
