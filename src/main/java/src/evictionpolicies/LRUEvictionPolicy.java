package src.evictionpolicies;

import src.datastructures.DLLNode;
import src.datastructures.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{
    DoublyLinkedList<Key> dll;
    Map<Key, DLLNode<Key>> keyToNodeMap;

    public LRUEvictionPolicy(){
        dll = new DoublyLinkedList<>();
        keyToNodeMap = new HashMap<>();
    }
    @Override
    public void keyAccessed(Key k) {
        if(!keyToNodeMap.containsKey(k)){
            DLLNode<Key> node = new DLLNode<>(k);
            dll.addToLast(node);
            keyToNodeMap.put(k, node);
        }
        else{
            DLLNode<Key> node = keyToNodeMap.get(k);
            dll.detachNode(node);
            dll.addToLast(node);
        }
    }

    @Override
    public Key getKeyToEvict() {
        DLLNode<Key> node = dll.getFirst();
        if(node==null){
            System.out.println("No key to evict. Empty DLL storage");
            return null;
        }
//        removeKey(node.getElement());
        return node.getElement();
    }

    @Override
    public void removeKey(Key k) {
        if(!keyToNodeMap.containsKey(k)){
            System.out.println("No such key "+k+" to remove");
            return;
        }
        DLLNode<Key> node = keyToNodeMap.get(k);
        dll.detachNode(node);
        keyToNodeMap.remove(k);
    }
}
