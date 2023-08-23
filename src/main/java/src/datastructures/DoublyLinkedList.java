package src.datastructures;

public class DoublyLinkedList<Key> {
    DLLNode head;

    public DoublyLinkedList(){
        head = null;
    }

    public void addToLast(DLLNode<Key> node){
        DLLNode<Key> temp = head;
        if(head==null){
            head = node;
            return;
        }
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }
    public void detachNode(DLLNode<Key> node){
        if(node.prev==null){
            DLLNode<Key> temp = head;
            head = head.next;
            temp.next = null;
            return;
        }
        if(node.next==null){
            node.prev.next = null;
            node.prev = null;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    public DLLNode<Key> getFirst(){
        return head;
    }
    public void printList(){
        System.out.println("Printing the DLL...");
        DLLNode<Key> temp = head;
        while(temp!=null){
            System.out.print(temp.getElement()+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
