package InMemoryCache;

public interface Cache {

    public String get(String key);
    public void set(String key, String value);
    public void delete(String key);
    public void begin();
    public boolean commit();
    public void rollback();
}
