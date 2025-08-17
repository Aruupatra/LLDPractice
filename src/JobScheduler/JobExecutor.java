package JobScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobExecutor {

    ExecutorService executorService= Executors.newFixedThreadPool(5);
    public void execute(Runnable job)
    {
        executorService.submit(job);
    }
}
