import java.util.*;

public class Collections {
    public static void main(String[] arrTest) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // Задание 3.1
        long startTime = System.nanoTime();
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        long endTime = System.nanoTime();
        System.out.println("Время преобразования массива в список: " + (endTime - startTime));

        startTime = System.nanoTime();
        Collection<?> collection = Arrays.asList(arr);
        endTime = System.nanoTime();
        System.out.println("Время преобразования массива в коллекцию: " + (endTime - startTime));

        // Задание 3.2
        startTime = System.nanoTime();
        list.add(0, 150);
        endTime = System.nanoTime();
        System.out.println("Время добавления элемента в список: " + (endTime - startTime));

        startTime = System.nanoTime();
        list.remove(3);
        endTime = System.nanoTime();
        System.out.println("Время удаления элемента из списка: " + (endTime - startTime));

        startTime = System.nanoTime();
        list.get(0);
        endTime = System.nanoTime();
        System.out.println("Время получения элемента из списка: " + (endTime - startTime));

        // Задание 3.3
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("Barsik");
        linkedList.addLast("Sharik");
        linkedList.addLast("Vasya");
        linkedList.removeFirst();
        linkedList.peekFirst();
        linkedList.peekLast();
        linkedList.removeLast();
        linkedList.addFirst("Bublik");
        linkedList.contains("Bublik");

        // Задание 3.3
        UnidirectionalList<Cat> myList = new UnidirectionalList<>();
        myList.addFirst(new Cat("Barsik"));
        myList.addLast(new Cat("Vasya"));
        myList.contains(new Cat("Barsik"));
        myList.peekFirst();
        myList.peekLast();

        // Задание 3.4
        BidirectionalList<Cat> catList = new BidirectionalList<>();
        catList.addFirst(new Cat("Barsik"));
        catList.addFirst(new Cat("Rygic"));
        catList.addLast(new Cat("Vasya"));
        catList.contains(new Cat("Bobik"));
        catList.size();

        // Задание 3.5
        ListIterator<Cat> iter = catList.iterator();
        startTime = System.nanoTime();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        endTime = System.nanoTime();
        System.out.println("Время вывода элементов связанного списка: " + (endTime - startTime));

        while (iter.hasPrevious()) {
            System.out.println(iter.previous());
        }

        if (catList.contains(new Cat("Barsik"))) {
            iter.remove();
        }

        // Задание 4.1
        MyArrayStack<Cat> catMyArrayStack = new MyArrayStack<>();

        startTime = System.nanoTime();
        catMyArrayStack.push(new Cat("Barsik"));
        endTime = System.nanoTime();
        System.out.println("Добавление котика в стек: " + (endTime - startTime));

        startTime = System.nanoTime();
        catMyArrayStack.peek();
        endTime = System.nanoTime();
        System.out.println("Выведение котика из стека: " + (endTime - startTime));

        startTime = System.nanoTime();
        catMyArrayStack.pop();
        endTime = System.nanoTime();
        System.out.println("Удаление котика из стека: " + (endTime - startTime));

        // Задание 4.2
        MyArrayQueue<Cat> catsArrayQueue = new MyArrayQueue<>();

        startTime = System.nanoTime();
        catsArrayQueue.offer(new Cat("Barsik"));
        endTime = System.nanoTime();
        System.out.println("Добавление котика в очередь: " + (endTime - startTime));

        catsArrayQueue.offer(new Cat("Vasya"));
        catsArrayQueue.offer(new Cat("Bublik"));
        startTime = System.nanoTime();
        catsArrayQueue.remove();
        endTime = System.nanoTime();
        System.out.println("Удаление котика из очереди: " + (endTime - startTime));

        startTime = System.nanoTime();
        catsArrayQueue.element();
        endTime = System.nanoTime();
        System.out.println("Выведение котика из очереди: " + (endTime - startTime));

        // Задание 4.3
        MyDequeue<Cat> catsDequeue = new MyDequeue<>();

        startTime = System.nanoTime();
        catsDequeue.addFirst(new Cat("Barsik"));
        endTime = System.nanoTime();
        System.out.println("Добавление котика в начало дека: " + (endTime - startTime));

        startTime = System.nanoTime();
        catsDequeue.addLast(new Cat("Vasya"));
        endTime = System.nanoTime();
        System.out.println("Добавление котика в конец дека: " + (endTime - startTime));

        //Задание 4.4
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        startTime = System.nanoTime();
        priorityQueue.offer("First");
        endTime = System.nanoTime();
        System.out.println("Добавление элемента в приоритетную очередь: " + (endTime - startTime));

        startTime = System.nanoTime();
        priorityQueue.poll();
        endTime = System.nanoTime();
        System.out.println("Удаление элемента из приоритетной очереди: " + (endTime - startTime));

        // Задание 4.5
        MyStack<Cat> catsStack = new MyStack<>();

        startTime = System.nanoTime();
        catsStack.push(new Cat("Barsik"));
        endTime = System.nanoTime();
        System.out.println("Время добавления котика в стек: " + (endTime - startTime));

        startTime = System.nanoTime();
        catsStack.peek();
        endTime = System.nanoTime();
        System.out.println("Время просмотра последнего котика в стеке: " + (endTime - startTime));

        startTime = System.nanoTime();
        catsStack.pop();
        endTime = System.nanoTime();
        System.out.println("Время удаления котика из стека: " + (endTime - startTime));

        MyQueue<Cat> catsQueue = new MyQueue<>(3);

        startTime = System.nanoTime();
        catsQueue.offer(new Cat("Barsik"));
        endTime = System.nanoTime();
        System.out.println("Время добавления котика в очередь: " + (endTime - startTime));

        catsQueue.offer(new Cat("Vasya"));

        startTime = System.nanoTime();
        catsQueue.element();
        endTime = System.nanoTime();
        System.out.println("Время возвращение котика из головы очереди с помощью element: " + (endTime - startTime));

        startTime = System.nanoTime();
        catsQueue.peek();
        endTime = System.nanoTime();
        System.out.println("Время возвращение котика из головы очереди с помощью peek: " + (endTime - startTime));

        startTime = System.nanoTime();
        catsQueue.poll();
        endTime = System.nanoTime();
        System.out.println("Время возвращение и удаления котика из головы очереди с помощью poll: " + (endTime - startTime));

        startTime = System.nanoTime();
        catsQueue.remove();
        endTime = System.nanoTime();
        System.out.println("Время возвращение и удаления котика из головы очереди с помощью remove: " + (endTime - startTime));
    }
}

