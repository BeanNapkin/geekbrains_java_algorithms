import java.util.NoSuchElementException;

public class MyQueue<T>  {
    private BidirectionalList<T> list = new BidirectionalList<>();
    private int maxSize;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public MyQueue() {
    }

    public boolean offer(T data) {
        if (list.size() == maxSize){
            return false;
        }
        list.addLast(data);
        return true;
    }


    public T remove() {
        if (list.peekFirst() == null){
            throw  new NoSuchElementException();
        }
        T temp = list.peekFirst();
        list.removeFirst();
        return temp;
    }


    public T poll() {
        if (list.peekFirst() == null){
            return null;
        }
        T temp = list.peekFirst();
        list.removeFirst();
        return temp;
    }


    public T element() {
        if (list.peekFirst() == null) throw new NoSuchElementException();
        return list.peekFirst();
    }


    public Object peek() {
        if (list.peekFirst() == null){
            return null;
        }
        return list.peekFirst();
    }
}
