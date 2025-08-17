package Kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Publisher {

    List<Topic> topics=new ArrayList<>();

    Random random=new Random();




    public void addTopic(Topic topic)
    {
        topics.add(topic);
    }

    public void publish(Topic topic,String messgage)
    {

                List<Partition> partitions=topic.partitions;
                Partition partition=partitions.get(random.nextInt(partitions.size()));
                Message message=new Message(messgage);
                partition.messageList.add(message);


    }

}
