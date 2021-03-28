import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class ArrayQueueTest {
    @Test
    public void test() {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(3);

        NoSuchElementException exception = null;

        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            exception = e;
        }

        Assertions.assertNotNull(exception);
        Assertions.assertNull(queue.poll());

        exception = null;

        try {
            queue.element();
        } catch (NoSuchElementException e){
            exception = e;
        }

        Assertions.assertNotNull(exception);

        Assertions.assertNull(queue.peek());

        Assertions.assertNull(queue.poll());

        queue.offer(5);
        queue.offer(7);

        Assertions.assertEquals(5, queue.element());
        Assertions.assertEquals(5, queue.peek());

        Assertions.assertTrue(queue.offer(9));
        Assertions.assertFalse(queue.offer(4));

        Assertions.assertEquals(5, queue.poll());
        Assertions.assertEquals(7, queue.remove());
        Assertions.assertEquals(9, queue.remove());
    }
}
