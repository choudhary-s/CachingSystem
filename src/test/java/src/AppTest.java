package src;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import src.datastructures.DLLNode;
import src.datastructures.DoublyLinkedList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testDll(){
        DoublyLinkedList dll = new DoublyLinkedList();
        DLLNode a = new DLLNode("A");
        DLLNode b = new DLLNode("B");
        DLLNode c = new DLLNode("C");

        dll.addToLast(a);
        dll.addToLast(b);
        dll.addToLast(c);
        dll.printList();
        System.out.println(dll.getFirst().getElement());
        dll.detachNode(c);
        dll.printList();
        assertTrue( true );
    }
}
