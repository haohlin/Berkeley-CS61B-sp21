package deque;

public class LinkedListDeque<ElemType> {
    private int size;
    private Node sentinel;

    public class Node {
        public ElemType item;
        public Node prev;
        public Node next;

        public Node() {
            item = null;
            prev = null;
            next = null;
        }

        public Node(ElemType i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addLast(ElemType i) {
        Node newNode = new Node();
        newNode.item = i;
        size++;

        Node prevLast = sentinel.prev;
        sentinel.prev.next = newNode;
        newNode.next = sentinel;
        sentinel.prev = newNode;
        newNode.prev =prevLast;
    }

    public void addFirst(ElemType i) {
        Node newNode = new Node();
        newNode.item = i;
        size++;

        Node prevFirst = sentinel.next;
        sentinel.next = newNode;
        newNode.next = prevFirst;
        prevFirst.prev = newNode;
        newNode.prev = sentinel;
    }

    public ElemType removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Cannot remove; Deque is empty!");
            return null;
        }
        size--;
        ElemType removed = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return removed;
    }

    public ElemType removeLast() {
        if (this.isEmpty()) {
            System.out.println("Cannot remove; Deque is empty!");
            return null;
        }
        size--;
        ElemType removed = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return removed;
    }

    public int size() {
        return size;
    }

    public ElemType get(int i) {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        ElemType foundItem;

        if (i <= size / 2) {
            foundItem = this.getFromFront(i);
        } else {
            foundItem = this.getFromBehind(i);
        }
        return foundItem;
    }

    public ElemType getFromFront(int i) {
        Node tempNode = sentinel.next;
        int counter = 0;
        while (tempNode != sentinel) {
            if (counter == i) {
                return tempNode.item;
            }
            counter++;
            tempNode = tempNode.next;
        }
        System.out.println("Index out of range!");
        return null;
    }

    public ElemType getFromBehind(int i) {
        Node tempNode = sentinel.prev;
        int counter = 0;
        while (tempNode != sentinel) {
            if (counter == size - i - 1) {
                return tempNode.item;
            }
            counter++;
            tempNode = tempNode.prev;
        }
        System.out.println("Index out of range!");
        return null;
    }

    public ElemType getRecursive(int i) {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        ElemType foundItem;

        if (i <= size / 2) {
            foundItem = recursiveFront(sentinel.next, i);
        } else {
            foundItem = recursiveBack(sentinel.prev, size - i - 1);
        }
        return foundItem;
    }

    public ElemType recursiveFront(Node n, int i) {
        if (n == sentinel) {
            System.out.println("Index out of range!");
            return null;
        }
        if (i == 0) {
            return n.item;
        }
        ElemType foundItem = recursiveFront(n.next, i - 1);
        return foundItem;
    }

    public ElemType recursiveBack(Node n, int i) {
        if (n == sentinel) {
            System.out.println("Index out of range!");
            return null;
        }
        if (i == 0) {
            return n.item;
        }
        ElemType foundItem = recursiveFront(n.prev, i - 1);
        return foundItem;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printDeque() {
        Node tempNode = sentinel.next;
        while (tempNode != sentinel) {
            System.out.print(tempNode.item + " ");
            tempNode = tempNode.next;
        }
        System.out.print("\n");
    }

    public LinkedListDeque(int l){

    }

}