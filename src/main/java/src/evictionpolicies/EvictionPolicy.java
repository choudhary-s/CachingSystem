package src.evictionpolicies;

public interface EvictionPolicy<Key>{
    void keyAccessed(Key k);
    Key getKeyToEvict();
    void removeKey(Key k);
}
