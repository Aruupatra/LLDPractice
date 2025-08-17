package Kafka;

import java.util.Random;
import java.util.*;

public class Subscriber {

    Random random=new Random();

    public void subScribeTopic(Topic topic)
    {
        List<Partition> partitionList=topic.partitions;
        for(Partition partition:partitionList)
        {
            partition.addSubscriber(this);
            new Thread(() -> consume(partition)).start();;

        }

    }

    public void consume(Partition partition)
    {
        while(true)
        {

                Message message=partition.getNextMessageForSubscriber(this);
                if(message!=null)
                {
                    processMessage(message);
                }


        }
    }
    public void processMessage(Message message)
    {
        System.out.println("Message Consumed"+message.message);
    }
}
