package synthesizer;// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        this.fillCount = 0;
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (this.fillCount == capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }

        this.fillCount += 1;//更新现存的item数量
        rb[last] = x;
        last += 1;
        if (last == this.capacity) {
            last = 0;
        }

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     * first指向当前队列中最先被插入的结点，last指向下一次插入的索引
     */
    public T dequeue() {
        if (this.fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");

        }
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update first
        T temp = rb[first];
        //得到当前first结点指向的item

        fillCount -= 1;
        first += 1;

        if (first == this.capacity) {
            first = 0;
        }
        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {

        int temp = first;
//        first += 1;
//        if (first == capacity) {
//            first = 0;
//        }

        return rb[temp];
        // TODO: Return the first item. None of your instance variables should change.
    }

    @Override
    public Iterator<T> iterator() {
        return new KeyIterator(this.fillCount,rb);
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
