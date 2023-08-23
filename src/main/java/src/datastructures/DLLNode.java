package src.datastructures;

import lombok.Data;

@Data
public class DLLNode<Key>{
    DLLNode prev;
    DLLNode next;
    Key element;

    public DLLNode(Key element) {
        this.element = element;
    }
}
