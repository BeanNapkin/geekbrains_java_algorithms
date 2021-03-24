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
        BiDirectionalList<Cat> catList = new BiDirectionalList<>();
        catList.addFirst(new Cat("Barsik"));
        catList.addFirst(new Cat("Rygic"));
        catList.addLast(new Cat("Vasya"));
        catList.contains(new Cat("Bobik"));
        catList.size();

        // Задание 3.5
        ListIterator<Cat> iter = catList.iterator();
        startTime = System.nanoTime();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        endTime = System.nanoTime();
        System.out.println("Время вывода элементов связанного списка: " + (endTime - startTime));
    }
}

