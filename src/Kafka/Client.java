package Kafka;

public class Client {
    public static void main(String args[]) throws InterruptedException {

        Topic topic1=new Topic("SPORTS",2);
        Topic topic2=new Topic("NEWS",3);

        Subscriber subscriber1=new Subscriber();
        subscriber1.subScribeTopic(topic1);
        subscriber1.subScribeTopic(topic2);

        Publisher publisher=new Publisher();
        publisher.publish(topic1,"India Win by 9 Run");
        publisher.publish(topic2,"Covid still impacting human body");

        Thread.sleep(5000);

        publisher.publish(topic1,"Sorry India lost the match");

    }
}
