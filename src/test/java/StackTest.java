import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void test(){
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(10);
        myStack.push(3);
        myStack.push(15);

        Assertions.assertEquals(15, myStack.peek());

        Assertions.assertEquals(15, myStack.pop());
        Assertions.assertEquals(3, myStack.pop());
        Assertions.assertEquals(10, myStack.pop());
    }
}
