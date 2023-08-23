package src;

import src.evictionpolicies.LRUEvictionPolicy;
import src.storages.HashMapBasedStorage;

public class CacheFactory {
    public Cache getDefaultCache(){
        return new Cache<>(new LRUEvictionPolicy(), new HashMapBasedStorage(5));
    }
}
