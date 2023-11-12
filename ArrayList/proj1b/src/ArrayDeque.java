import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    public static void main(String[] args) {
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
    }
    // Instance Variables
    T[] list;
    private static final int INITIAL_CAPACITY = 8;
    private int size;
    private int firstIndex;
    private int lastIndex;

    // Constructor
    public ArrayDeque() {
        list = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        firstIndex = 0;
        lastIndex = 0;
    }

    @Override
    public void addFirst(T x) {
        // Check if we need to upsize / downsize before performing any operation
        checkSize();
        if (isEmpty()) {
            // initialize -  first item position becomes x
            list[firstIndex] = x;
        } else {
            // add item - (1) move first index to left (2) put item to the left position
            firstIndex = moveIndexLeft(firstIndex);
            list[firstIndex] = x;
        }
        size++;
    }

    @Override
    public void addLast(T x) {
        checkSize();
        if (isEmpty()) {
            list[lastIndex] = x;
        } else {
            lastIndex = moveIndexRight(lastIndex);
            list[lastIndex] = x;
        }
        size++;
    }

    @Override
    public List<T> toList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T x = list[firstIndex];
        list[firstIndex] = null;
        firstIndex = moveIndexRight(firstIndex);
        size--;
        checkSize();
        return x;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T x = list[lastIndex];
        list[lastIndex] = null;
        lastIndex = moveIndexLeft(lastIndex);
        size--;
        checkSize();
        return x;
    }

    @Override
    public T get(int index) {
        return list[index];
    }

    /**
     * Helper Methods
     */
    private void checkSize() {
        if (size != 0 && size < (list.length * 0.25)) {
            downSize();
        } else if (size == list.length) {
            upSize();
        }
    }

    private void upSize() {

    }

    private void downSize() {
    }

    private int moveIndexLeft(int index) {
        int newPosition = index--;
        return newPosition % list.length;
    }

    private int moveIndexRight(int index) {
        int newPosition = index++;
        return newPosition % list.length;
    }
}
