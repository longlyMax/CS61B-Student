import org.junit.Test;

/**
 * @author longlyMax
 * @version 1.0
 */
public class ListDequeTest {

    @Test
    public void testAdd() {
        LinkedListDeque<Integer> listDeque = new LinkedListDeque<>();
        listDeque.addFirst(3);
        listDeque.addFirst(2);
        listDeque.addFirst(1);
        listDeque.addFirst(0);
        listDeque.printDeque();
    }

    @Test
    public void testRemove() {
        LinkedListDeque<Integer> listDeque = new LinkedListDeque<>();
        listDeque.addFirst(3);
        listDeque.addFirst(2);
        listDeque.addFirst(1);
        listDeque.addFirst(0);

        listDeque.removeLast();
        listDeque.printDeque();

        listDeque.removeFirst();
        listDeque.printDeque();
    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> listDeque = new LinkedListDeque<>();
        listDeque.addFirst(3);
        listDeque.addFirst(2);
        listDeque.addFirst(1);
        listDeque.addFirst(0);

        Integer i = listDeque.get(0);
        System.out.println(i);

        Integer recursive = listDeque.getRecursive(2);
        System.out.println(recursive);
    }
}
