package JobScheduler;

import java.util.UUID;

public class JobMetadata {

    UUID id;
    int interval;
    long nextRunTime;
    boolean isCancelled;
    int priority;
    JobMetadata(int interval,boolean isCancelled,int priority)
    {
        this.id= UUID.randomUUID();
        this.interval=interval;
        this.nextRunTime=System.currentTimeMillis();
        this.isCancelled=isCancelled;
        this.priority=priority;
    }
}
