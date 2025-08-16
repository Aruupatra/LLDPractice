package InMemoryCache;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class KeyValueCache implements Cache {
    HashMap<String,VersionValue> data;
    ThreadLocal<Transaction> currentTransaction;
    AtomicLong atomicLong;

    KeyValueCache()
    {
        data=new HashMap<>();
        currentTransaction =new ThreadLocal<>();
        atomicLong=new AtomicLong(0);

    }
    @Override
    public String get(String key) {
        Transaction transaction= currentTransaction.get();
        if(transaction==null)
        {
            return data.get(key)==null?null:data.get(key).value;
        }
        if(transaction != null)
        {
            if(transaction.deleteSet.contains(key))
            {
                return null;
            }
            if(transaction.write.containsKey(key))
            {
                return transaction.write.get(key);
            }
        }
        VersionValue value=null;
        if(data.containsKey(key))
        {
           value =data.get(key);
        }

        transaction.read.put(key,value);

        return value.value;
    }

    @Override
    public void set(String key, String value) {
        Transaction transaction= currentTransaction.get();
        if(transaction==null)
        {
            data.put(key,new VersionValue(value,atomicLong.incrementAndGet()));
        }
        else {
            transaction.write.put(key,value);
            transaction.deleteSet.remove(key);
        }

    }

    @Override
    public void delete(String key) {
        Transaction transaction= currentTransaction.get();
        if(transaction != null) {
            transaction.deleteSet.add(key);
            transaction.write.remove(key);
        }
        else {
            data.remove(key);
        }

    }

    @Override
    public void begin() {
        Transaction transaction= currentTransaction.get();
        if(transaction != null)
        {
            throw new IllegalStateException("Transaction already is in progress");
        }

     currentTransaction.set(new Transaction());
    }

    @Override
    public boolean commit() {
        Transaction transaction= currentTransaction.get();
        if(transaction == null)
        {
            throw new IllegalStateException("No transaction proceed");
        }

        for(String key:transaction.read.keySet())
        {
            VersionValue value=transaction.read.get(key);
            if(data.get(key)==null || data.get(key).version != value.version)
            {
                currentTransaction.remove();
                return false;
            }
        }

        for(String key:transaction.deleteSet)
        {
            data.remove(key);
        }
        for(String key:transaction.write.keySet())
        {
            String value=transaction.write.get(key);
            data.put(key,new VersionValue(value,atomicLong.incrementAndGet()));
        }
        currentTransaction.remove();
        return true;
    }

    @Override
    public void rollback() {

        Transaction transaction= currentTransaction.get();

        if(transaction==null)
        {
            throw  new IllegalStateException("No Transaction currently Running");
        }
     currentTransaction.remove();
    }
}
