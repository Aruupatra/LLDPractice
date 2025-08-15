package LoggingAdvanceLibrary.Logs;

import LoggingAdvanceLibrary.LogFactory;

public class PrintLog implements LogTarget{

    String logLevel;
    static{
        LogFactory.register("print", config ->
                {
                    System.out.println(config);
                    return new PrintLog(config.logLevel);
                });
    }
    PrintLog(String logLevel)
    {
        this.logLevel=logLevel;
    }
    @Override
    public void log(String message) {
        System.out.println("Log Printed on Console"+message);
    }
}
