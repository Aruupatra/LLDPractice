package InMemoryCache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

public class Transaction {

    HashMap<String,VersionValue> read;
    HashSet<String> deleteSet;
    HashMap<String, String> write;

    Transaction()
    {
        read=new HashMap<>();
        deleteSet=new HashSet<>();
        write=new HashMap<>();

    }
}
