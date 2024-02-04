import org.junit.Test;

/**
 * @author longlyMax
 * @version 1.0
 */
public class ArrayDeque <T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;//初始化数组和首尾指针
    }

    public void resize(int capacity) {
        T[] array = (T[]) new Object[capacity];
        if ((nextLast - 1) < (nextFirst + 1)) {
            //通过两个for循环完成数组项的填充，因为是双端数组，故不可使用Array.copy
            int temp = 0;
            for (int i = nextFirst + 1; i < items.length; i++) {
                array[temp++] = items[i];
            }
            for (int i = 0; i < nextLast; i++) {
                array[temp++] = items[i];
            }
        } else {
            for (int i = nextFirst + 1, j = 0; i < nextLast; i++, j++) {
                array[j] = items[i];
            }
        }
        items = array;
        nextFirst = items.length - 1;
        nextLast = size;
        //相应首尾指针也要调整
    }

    public void addFirst(T x) {
        if (size == items.length) {
            resize(size + size);//超过数组尺寸则调整大小
        }
        items[nextFirst] = x;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;//循环数组处理过界情况
        }
        size += 1;//相应调整
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size + size);
        }
        items[nextLast] = x;
        nextLast += 1;
        if (nextLast > (items.length - 1)) {
            nextLast = 0; //循环数组处理过界情况
        }
        size += 1;
    }

    public T removeFirst() {
        T x = getFirst();
        nextFirst += 1;
        if (nextFirst > (items.length - 1)) {
            nextFirst = 0; //循环数组处理过界情况
        }
        items[nextFirst] = null;
        size -= 1;//处理数组大小
        return x;
    }

    public T getFirst() {
        int temp = nextFirst;
        temp += 1;
        if (temp > (items.length - 1)) {
            temp = 0; //循环数组处理过界情况
        }
        return items[temp];
    }

    public T removeLast() {
        T x = getLast();
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = items.length - 1;//循环数组处理过界情况
        }
        items[nextLast] = null;
        size -= 1;
        return x;
    }

    public T getLast() {
        int temp = nextLast;
        temp += 1;
        if (temp < 0) {
            temp = (items.length - 1); //循环数组处理过界情况
        }
        return items[temp];
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
        if (nextLast <= nextFirst) {
            for (int i = nextFirst + 1; i < items.length; i++) {
                System.out.println(items[i]);
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.println(items[i]);
            }
        } else {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                System.out.println(items[i]);
            }
        }
    }

    public T get(int i) {
        return items[i];
    }
}
