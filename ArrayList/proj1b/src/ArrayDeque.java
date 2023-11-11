import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    public static void main(String[] args) {
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
    }
    int availableCapacity = 8;
    int size = 0;
    int frontIndex = 0;
    int backIndex = 0;

    public ArrayDeque() {
        List<T> list = new ArrayList<>(8);
        availableCapacity = 8;
        size = 0;
        frontIndex = 0;
        backIndex = 0;
    }

    @Override
    public void addFirst(T x) {
        if (size == 0 && frontIndex == 0) {
            addLast();
        }
        list[]
        size += 1;
        if (size == availableCapacity) {
            resize();
        }
    }

    @Override
    public void addLast(T x) {

    }

    private void resize(){

    }

    @Override
    public List<T> toList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }
}
