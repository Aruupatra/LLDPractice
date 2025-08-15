package LoggingAdvanceLibrary;

import LoggingAdvanceLibrary.Logs.LogTarget;

import java.util.HashMap;
import java.util.function.Function;

public class LogFactory {

     static HashMap<String, Function<LogConfig, LogTarget>> registry=new HashMap<>();

     public static void register(String type, Function<LogConfig, LogTarget> targetFunction)
     {
         registry.put(type,targetFunction);
     }

     static LogTarget create(LogConfig config)
     {
         Function<LogConfig,LogTarget> ll=registry.get(config.target);
         return ll.apply(config);
     }

}
