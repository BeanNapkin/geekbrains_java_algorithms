import java.util.ArrayList;

public class MyArrayStack<T> {

    private ArrayList<T> list = new ArrayList<>();

    public void push(T data){
        list.add(data);
    }

    public T pop(){
     T temp = list.get(list.size()-1);
     list.remove(list.size() -1);
     return temp;
    }

    public T peek(){
        return list.get(list.size()-1);
    }
}
