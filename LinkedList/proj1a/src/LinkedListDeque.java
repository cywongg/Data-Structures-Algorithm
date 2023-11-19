import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    private Node sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
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

    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
    }

    @Override
    public void addFirst(T x) {
        // creates a new node that points at previous "first" node (as next), and points back to sentinel (as prev)
        Node newNode = new Node(x, sentinel.next, sentinel);
        // the previous "first" node will point back to the new first node (as prev)
        sentinel.next.prev = newNode;
        // the sentinel will point to the new first node (as next)
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        // creates a new node that points at the previous last node (as prev), and points to sentinel (as next)
        Node newNode = new Node(x, sentinel, sentinel.prev);
        // the previous "last" node will point to the new last node (as next)
        sentinel.prev.next = newNode;
        // the sentinel will point to the new last node (as prev)
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public List toList() {
        if (isEmpty()){
            return List.of();
        }
            List list = new ArrayList<>();
            Node p = sentinel;
            while (p.next != sentinel) {
                p = p.next;
                list.add(p.item);
            }
        return list;
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
        size--;
        // creates a pointer to first node
        Node node = sentinel.next;
        // make sentinel points to the next item (as next)
        sentinel.next = node.next;
        // make next item points to sentinel (as prev)
        sentinel.next.prev = sentinel;
        return node.item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size--;
        // creates a pointer to first node
        Node node = sentinel.prev;
        // make sentinel points to the 2nd last item (as prev)
        sentinel.prev = node.prev;
        // make 2nd last itm points to sentinel (as next)
        sentinel.prev.next = sentinel;
        return node.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index > (size - 1) / 2) {
            Node node = traverseBack(size - 1 - index); // starts at last, count backward
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
