package JobScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

public class JobScedulerService {

      Map<UUID,Job> jobMap=new ConcurrentHashMap<>();
      Map<UUID,JobMetadata> jobMetadataMap=new ConcurrentHashMap<>();
      PriorityBlockingQueue<JobMetadata> queue=new PriorityBlockingQueue<>(100,new JobComparator());
      JobExecutor jobExecutor=new JobExecutor();
      public UUID scheduleJob(Job job,int interval)
      {
          JobMetadata jobMetadata=new JobMetadata(interval,false,1);
          UUID id=jobMetadata.id;
          jobMap.put(id,job);
          jobMetadataMap.put(id,jobMetadata);
          queue.add(jobMetadata);
        return id;
      }

      public void start() throws InterruptedException {
          new Thread(() -> {
              while(true)
              {
                  JobMetadata metadata=queue.poll();
                  if(metadata==null || metadata.isCancelled)
                  {

                      continue;
                  }
                  long currentTime=System.currentTimeMillis();
                  try {
                      Thread.sleep(2);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
                  if(metadata.nextRunTime<=currentTime)
                  {
                      Job job=jobMap.get(metadata.id);
                      jobExecutor.execute(() ->
                      {
                          System.out.println("Executing job with ID: " + metadata.id);
                          job.execute();
                      });
                      metadata.nextRunTime+=metadata.interval;
                      queue.add(metadata);
                  }


              }
          }).start();
      }
}
