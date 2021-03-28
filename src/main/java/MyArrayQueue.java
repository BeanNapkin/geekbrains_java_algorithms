import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyArrayQueue<T>  {
    private ArrayList<T> list = new ArrayList<>();
    private int maxSize;

    public MyArrayQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public MyArrayQueue() {
    }

    public boolean offer(T data) {
        if (list.size() == maxSize){
            return false;
        }
        list.add(data);
        return true;
    }


    public T remove() {
        if (list.isEmpty()){
            throw  new NoSuchElementException();
        }
        T temp = list.get(0);
        list.remove(0);
        return temp;
    }


    public T poll() {
        if (list.isEmpty()){
            return null;
        }
        T temp = list.get(0);
        list.remove(0);
        return temp;
    }


    public T element() {
        if (list.isEmpty()) throw new NoSuchElementException();
        return list.get(0);
    }


    public Object peek() {
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
