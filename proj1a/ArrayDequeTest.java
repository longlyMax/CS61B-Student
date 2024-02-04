import org.junit.Test;

/**
 * @author longlyMax
 * @version 1.0
 */
public class ArrayDequeTest {
    @Test
    public void test01() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.printDeque();

        arrayDeque.addLast(-1);
        arrayDeque.printDeque();


    }

    @Test
    public void test02() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);

        Integer i = arrayDeque.removeFirst();
//        System.out.println(i);
        arrayDeque.printDeque();

        arrayDeque.removeLast();
        arrayDeque.printDeque();

        System.out.println(arrayDeque.size());
    }

    @Test
    public void test03() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(4);

        arrayDeque.printDeque();
    }
}
