package JobScheduler;

import java.util.UUID;

public class client {
    public static void main(String args[]) throws InterruptedException {
        Job job= ()->System.out.println("Hi");
        JobScedulerService jobScedulerService=new JobScedulerService();
        UUID id=jobScedulerService.scheduleJob(job,5);

        jobScedulerService.start();
    }
}
