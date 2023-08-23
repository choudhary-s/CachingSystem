package src.storages;

import src.exceptions.NoSuchKeyException;
import src.exceptions.StorageException;

public abstract class Storage<Key, Value>{
    int size;
    public Storage(int size){
        this.size = size;
    }
    public abstract void put(Key k, Value v) throws StorageException;
    public abstract Value get(Key k) throws NoSuchKeyException;
    public abstract void remove(Key k) throws NoSuchKeyException;
}
