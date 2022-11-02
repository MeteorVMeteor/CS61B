package deque;

public class LinkedListDeque<T> {
    public class Node{
        T item;
        Node prev;
        Node next;

        public Node(T item){
            this.item = item;
        }

        public void setPrev(Node prevNode){
            this.prev = prevNode;
        }

        public void setNext(Node nextNode){
            this.next = nextNode;
        }
    }

    private Node dummy;
    private int size;
    public LinkedListDeque(){
        this.dummy = new Node(null);
        dummy.setPrev(dummy);
        dummy.setNext(dummy);
        size = 0;
    }

    public LinkedListDeque(T item){
        this.dummy = new Node(null);
        Node node = new Node(item);
        dummy.setNext(node);
        dummy.setPrev(node);
        node.setPrev(dummy);
        node.setNext(dummy);
        size += 1;
    }

    public void addFirst(T item){
        Node node = new Node(item);
        node.setNext(dummy.next);
        node.setPrev(dummy);
        node.next.setPrev(node);
        dummy.setNext(node);
        size += 1;
    }

    public void addLast(T item){
        Node node = new Node(item);
        node.setNext(dummy);
        node.setPrev(dummy.prev);
        dummy.setPrev(node);
        node.prev.setNext(node);
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node tmp = dummy.next;
        while(tmp != dummy){
            System.out.print(tmp.item);
            System.out.print(" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public T get(int index){
        Node pointer = dummy;
        for(int i = 0; i <= index && index < size; i++){
            pointer = pointer.next;
        }
        return pointer.item;
    }

    public T getRecursive(int index){
        return getRecurHelp(index, 0, dummy.next);
    }

    private T getRecurHelp(int index, int n, Node node){
        if(index == n){
            return node.item;
        }
        if(node == dummy){
            return null;
        }
        return getRecurHelp(index, n+1, node.next);
    }

    public boolean equals(Object o){
        return o instanceof LinkedListDeque;
    }

    public T removeFirst(){
        Node node = dummy.next;
        dummy.next.next.setPrev(dummy);
        dummy.setNext(dummy.next.next);
//        node.setPrev(null);
//        node.setNext(null);
        size = Math.max(size - 1, 0);
        return node.item;
    }

    public T removeLast(){
        Node node = dummy.prev;
        dummy.setPrev(dummy.prev.prev);
        dummy.prev.prev.setNext(dummy);
        size = Math.max(size - 1, 0);
        return node.item;
    }
}
