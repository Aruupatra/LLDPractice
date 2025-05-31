package LoggingLibrary.appender;

import LoggingLibrary.LogMessage;
import LoggingLibrary.LoggerLevel;

public class DBAppender implements Appender{

    LoggerLevel loggerLevel;
    String endpoint;
    boolean isSync;
    int port;
    public DBAppender(LoggerLevel loggerLevel,String endpoint,boolean isSync,int port)
    {
        this.loggerLevel=loggerLevel;
        this.endpoint=endpoint;
        this.isSync=isSync;
        this.port=port;
    }

    public void append(LogMessage logMessage) {
        System.out.println("DBAppendder -> "+logMessage.getMessage().toLowerCase());
    }

    public boolean isSync() {
        return isSync;
    }


    public LoggerLevel getLevel() {
        return this.loggerLevel;
    }
}
