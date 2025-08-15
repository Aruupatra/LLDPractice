package LoggingAdvanceLibrary.Logs;

import LoggingAdvanceLibrary.LogFactory;

public class DbLog implements LogTarget{
    static
    {
        LogFactory.register("db", config -> new DbLog(config.portNo));
    }
    int portNumber;

    DbLog(int portNumber)
    {
        this.portNumber=portNumber;
    }

    @Override
    public void log(String message) {
     System.out.println("db log"+message);
    }
}
