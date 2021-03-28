public class MyStack<T> {

    private MyDequeue<T> list = new MyDequeue<>();

    public void push(T data){
        list.addLast(data);
    }

    public T pop(){
     T temp = list.peekLast();
     list.removeLast();
     return temp;
    }

    public T peek(){
        return list.peekLast();
    }
}
