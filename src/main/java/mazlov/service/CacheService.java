package mazlov.service;

public interface CacheService {
    Object getFromCache(String key);

    public Object addToCache(String key, Object value);

}
