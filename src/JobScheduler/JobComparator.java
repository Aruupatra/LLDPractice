package JobScheduler;

import java.util.Comparator;

public class JobComparator implements Comparator<JobMetadata> {

    @Override
    public int compare(JobMetadata o1, JobMetadata o2) {

        if(o1.nextRunTime != o2.nextRunTime)
        {
            return Long.compare(o1.nextRunTime,o2.nextRunTime);
        }
        return Integer.compare(o2.priority, o1.priority);
    }
}
