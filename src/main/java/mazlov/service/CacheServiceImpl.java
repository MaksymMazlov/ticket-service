package mazlov.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CacheServiceImpl implements CacheService {
    private final Cache cache = new Cache(10);

    @Override
    public Object getFromCache(String key) {
        return cache.get(key);
    }

    @Override
    public Object addToCache(String key, Object value) {
        return cache.put(key, value);
    }

    private static class Cache extends LinkedHashMap<String, Object> {
        private final int maxCapacity;

        public Cache(int initialCapacity) {
            super(initialCapacity);
            this.maxCapacity = initialCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return this.size() > maxCapacity;
        }
    }
}
