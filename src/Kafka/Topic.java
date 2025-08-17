package Kafka;

import java.util.ArrayList;
import java.util.List;

public class Topic {


    String name;
    List<Partition> partitions;

    Topic(String name,int nop)
    {
        this.name=name;
        partitions=new ArrayList<>();
        for(int i=0;i<nop;i++)
        {
            partitions.add(new Partition(i));
        }
    }

}
