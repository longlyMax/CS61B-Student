package synthesizer;

/**
 * @author longlyMax
 * @version 1.0
 */
public interface BoundedQueue<T> extends Iterable<T>{
    int capacity();     // return size of the buffer

    int fillCount();    // return number of items currently in the buffer

    void enqueue(T x);  // add item x to the end

    T dequeue();        // delete and return item from the front

    T peek();           // return (but do not delete) item from the front

    default boolean isEmpty()       // is the buffer empty (fillCount equals zero)?
    {
        int fillCount = this.fillCount();
        if (fillCount != 0) {

            return false;
        }

        return true;
    }

    default boolean isFull()        // is the buffer full (fillCount is same as capacity)?
    {
        int fillCount = this.fillCount();
        if (fillCount == this.capacity()) {
            return true;
        }
        return false;
    }
}
