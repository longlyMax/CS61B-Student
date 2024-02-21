/**
 * @author longlyMax
 * @version 1.0
 */
public class LinkedListDeque<Item> implements Deque<Item> {
    private Node sential;
    private int size;

    private static class Node<Item> {
        public Item item;
        public Node next;
        public Node pre;

        public Node(Item value, Node n) {
            item = value;
            next = n;
            pre = n;
//            pre = n.pre;
            if (n != null) {
                next = n;
                n.pre.next = this;
                this.pre = n.pre;
                n.pre = this;
            }
        }
    }

    public LinkedListDeque() {
        sential = new Node(66, null);
        sential.pre = sential;
        sential.next = sential;
        size = 0;
    }


    public void addFirst(Item item) {
        sential.next = new Node(item, sential.next);
        size += 1;
    }

    public void addLast(Item item) {
        sential.pre.next = new Node(item, sential.pre.next);
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<Item> node = sential.next;
        for (int i = 0; i < size; i++) {
            System.out.println(node.item);
            node = node.next;
        }
    }

    public Item removeFirst() {
        Item value = (Item) sential.next.item;
        sential.next.next.pre = sential;
        sential.next = sential.next.next;

        size -= 1;

        return value;
    }

    public Item removeLast() {
        Item item = (Item) sential.pre.item;
        sential.pre.pre.next = sential;
        sential.pre = sential.pre.pre;

        size -= 1;

        return item;
    }

    public Item get(int index) {
        if ((index + 1) > size) {
            return null;
        }
        Node<Item> res = sential.next;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }


        return res.item;
    }

    public Item getRecursive(int index) {
        return getRecursive(index, sential.next);
    }

    public Item getRecursive(int index, Node res) {
        if (index == 0) {
            return (Item) res.item;
        }
        return getRecursive(--index, res.next);
    }
}
