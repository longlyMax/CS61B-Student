package synthesizer;

import java.util.Iterator;

/**
 * @author longlyMax
 * @version 1.0
 */
public class KeyIterator<T> implements Iterator<T> {
    private int ptr;

    private int size;

    private T[] rb;

    public KeyIterator(int count, T[] array) {
        ptr = 0;
        size = count;
        rb = array;
    }

    @Override
    public boolean hasNext() {
        return (ptr != size);
    }

    @Override
    public T next() {
        T returnItem = rb[ptr];
        ptr += 1;
        return returnItem;
    }
}
