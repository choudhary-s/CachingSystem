package src;

import src.evictionpolicies.EvictionPolicy;
import src.exceptions.NoSuchKeyException;
import src.exceptions.StorageException;
import src.storages.Storage;

public class Cache<Key, Value>{
    EvictionPolicy<Key> evictionPolicy;
    Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void add(Key k, Value v){
        try {
            storage.put(k, v);
            evictionPolicy.keyAccessed(k);
            System.out.println("Added key: "+k+" value: "+v);
        }
        catch (StorageException ex){
            System.out.println("Storage full exception encountered");
            Key keyToEvict = evictionPolicy.getKeyToEvict();
            remove(keyToEvict);
            add(k, v);
        }
    }
    public void remove(Key k){
        try{
            storage.remove(k);
            evictionPolicy.removeKey(k);
            System.out.println("Removed key: "+k);
        }
        catch (NoSuchKeyException ex){
            System.out.println("No such key exception for key "+k);
        }
    }
    public Value get(Key k){
        try{
            Value v = storage.get(k);
            evictionPolicy.keyAccessed(k);
            System.out.println("Returning value: "+v+" for key: "+k);
            return v;
        }
        catch (NoSuchKeyException ex){
            System.out.println("No such key exception for key"+k);
        }
        return null;
    }
}
