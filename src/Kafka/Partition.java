package Kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Partition {

    int id;
    List<Message> messageList;
    HashMap<Subscriber, Integer> map;

    Partition(int id)
    {
        this.id=id;
        messageList=new ArrayList<>();
        map=new HashMap<>();
    }

    public void addSubscriber(Subscriber subscriber)
    {
        map.putIfAbsent(subscriber,0);

    }

    public Message getNextMessageForSubscriber(Subscriber subscriber)
    {
        int ci=map.get(subscriber);
        if(ci<messageList.size())
        {
            Message message=messageList.get(ci);
            map.put(subscriber,ci+1);
            return message;
        }

        return null;
    }



}
