package LoggingLibrary;

import lombok.Getter;

import java.util.Date;

@Getter
public class LogMessage {

    String message;
    LoggerLevel loggerLevel;
    Date currentTime;

}
