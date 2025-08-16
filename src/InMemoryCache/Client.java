package InMemoryCache;

public class Client {
    public static void main(String args[])
    {
        KeyValueCache cache=new KeyValueCache();
        cache.set("Arun","Patra");
        System.out.println(cache.get("Arun"));

        cache.begin();
        cache.set("Sipra","Patra");
        System.out.println(cache.get("Sipra"));
        System.out.println(cache.get("Arun"));
        cache.delete("Sipra");
        System.out.println(cache.get("Sipra"));
        cache.commit();


    }
}
