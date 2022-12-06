package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
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
    @Override
    public Iterator<T> iterator() {
        return new LLDequeIter();
    }

    private class LLDequeIter implements Iterator<T>{
        private int pointerIter;
        Node tmp = dummy;
        public LLDequeIter() {
            pointerIter = 0;
        }

        @Override
        public boolean hasNext() {
            return size < pointerIter;
        }

        @Override
        public T next() {
            pointerIter++;
            tmp = tmp.next;
            return tmp.item;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass() || ((LinkedListDeque)o).size() != this.size()) {
            return false;
        }
        Node tmp1 = this.dummy;
        Node tmp2 = ((LinkedListDeque)o).dummy;
        for (int i = 0; i < this.size(); i++) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
            if (tmp1.item != tmp2.item) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addFirst(T item){
        Node node = new Node(item);
        node.setNext(dummy.next);
        node.setPrev(dummy);
        node.next.setPrev(node);
        dummy.setNext(node);
        size += 1;
    }

    @Override
    public void addLast(T item){
        Node node = new Node(item);
        node.setNext(dummy);
        node.setPrev(dummy.prev);
        dummy.setPrev(node);
        node.prev.setNext(node);
        size += 1;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        Node tmp = dummy.next;
        while(tmp != dummy){
            System.out.print(tmp.item);
            System.out.print(" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    @Override
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

    @Override
    public T removeFirst(){
        Node node = dummy.next;
        dummy.next.next.setPrev(dummy);
        dummy.setNext(dummy.next.next);
//        node.setPrev(null);
//        node.setNext(null);
        size = Math.max(size - 1, 0);
        return node.item;
    }

    @Override
    public T removeLast(){
        Node node = dummy.prev;
        dummy.setPrev(dummy.prev.prev);
        dummy.prev.prev.setNext(dummy);
        size = Math.max(size - 1, 0);
        return node.item;
    }
}
