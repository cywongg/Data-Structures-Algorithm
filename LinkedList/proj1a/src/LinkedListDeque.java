import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    private class Node{
        private T item;
        private Node next;
        private Node prev;
        public Node(T i, Node x, Node y) {
            item = i;
            next = x;
            prev = y;
        }
    }
    private Node sentinel;
    private int size;

    private LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
    }


    @Override
    public void addFirst(T x) {
        //creates a new node that points at previous "first" node, and points back to sentinal
        Node newNode = new Node(x, sentinel.next, sentinel);
        //
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size ++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel, sentinel.next);
        sentinel.next.next = newNode;
        sentinel.prev = newNode;
    }

    @Override
    public List toList() {
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
        Node node = sentinel.next;
        sentinel.next = node.next;
        sentinel.next.prev = sentinel;
        return node.item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node node = sentinel.prev;
        sentinel.prev = node.prev;
        sentinel.prev.next = sentinel;
        return node.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index > (size - 1) / 2) {
            // counting from backward,
            Node node = traverseBack(size - 1 - index);
            return node.item;
        } else {
            Node node = traverseForward(index);
            return node.item;
        }
    }

    private Node traverseForward(int index) {
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p;
    }

    private Node traverseBack(int index) {
        Node p = sentinel.prev;
        while (index > 0) {
            p = p.prev;
            index--;
        }
        return p;
    }

    @Override
    public T getRecursive(int index) {
        if (index >= size || index < 0){
            return null;
        } return getRecursive(sentinel, index);
    }

    private T getRecursive(Node sentinel, int index) {
        if (index == 0) {
            return sentinel.next.item;
        } else {
            return getRecursive(sentinel.next, index - 1);
        }
    }

}
