package src.storages;

import src.exceptions.NoSuchKeyException;
import src.exceptions.StorageException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> extends Storage<Key, Value>{
    Map<Key, Value> storage;
    public HashMapBasedStorage(int size){
        super(size);
        this.storage = new HashMap<>();
    }
    @Override
    public void put(Key k, Value v) throws StorageException {
        if(storage.size()==size){
            throw new StorageException();
        }
        System.out.println("Inserting "+k+" "+v+" in Hashmap Storage");
        storage.put(k, v);
    }

    @Override
    public Value get(Key k) throws NoSuchKeyException {
        if(!storage.containsKey(k)){
            throw new NoSuchKeyException();
        }
        System.out.println("Retrieving value of "+k+" from Hashmap Storage");
        return storage.get(k);
    }

    @Override
    public void remove(Key k) throws NoSuchKeyException {
        if(!storage.containsKey(k)){
            throw new NoSuchKeyException();
        }
        System.out.println("Removing key "+k+" from Hashmap Storage");
        storage.remove(k);
    }
}
