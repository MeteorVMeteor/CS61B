package deque;

public class ArrayDeque<T> {
    private T[] deque;
    private int size;
    private int startindex;
    public ArrayDeque() {
        size = 0;
        deque = (T []) new Object[8];
        startindex = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T get(int index){
        return deque[getIndex(index)];
    }

    private int getIndex(int index){
        return (startindex + index) % deque.length;
    }

    private void startChange(int index){
        if(index == 0){
            startindex = 0;
        }
        else{
            startindex = (startindex + index + deque.length) % deque.length;
        }
    }
    private void arrayChange(int newsize){
        T[] tmp = (T []) new Object[newsize];
        //copy front part
        int frontpartsize = Math.min(size, deque.length - startindex);
        System.arraycopy(deque, getIndex(0), tmp, 0, frontpartsize);
        //copy rest part
        if (frontpartsize < size) {
            int respartsize = size - frontpartsize;
            System.arraycopy(deque, 0, tmp, frontpartsize, respartsize);
        }
        deque = tmp;
        startChange(0);
    }

    private void checkArrSize(){
        if ((double)size / deque.length >= 0.9) {
            arrayChange(deque.length * 2);
        } else if (deque.length > 16 && (double)size / deque.length <= 0.25) {
            arrayChange(deque.length / 2);
        }
    }

    public void addFirst(T item){
        checkArrSize();
        startChange(-1);
        int index = getIndex(0);
        deque[index] = item;
        size++;
    }

    public void addLast(T item){
        checkArrSize();
        int index = getIndex(size++);
        deque[index] = item;
    }

    public T removeFirst(){
        checkArrSize();
        if (size == 0) {
            return null;
        }
        int index = getIndex(0);
        startChange(1);
        T res = deque[index];
        size--;
        return res;
    }

    public T removeLast(){
        checkArrSize();
        if (size == 0) {
            return null;
        }
        int index = getIndex(--size);
        T res = deque[index];
        deque[index] = null;
        return res;
    }

    public void printDeque(){
        for(int i = 0; i < size; i++){
            int index = getIndex(i);
            System.out.print(deque[index]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
