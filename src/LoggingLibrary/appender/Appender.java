package LoggingLibrary.appender;

import LoggingLibrary.LogMessage;
import LoggingLibrary.LoggerLevel;

public interface Appender {
    void append(LogMessage logMessage);
    boolean isSync();
    LoggerLevel getLevel();

}
