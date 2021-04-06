public class TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();

        Person person = new Person(2, "Rita");
        tree.insert(person);
        person = new Person(5, "Vasya");
        tree.insert(person);
        person = new Person(7, "Katya");
        tree.insert(person);
        person = new Person(6, "Vanya");
        tree.insert(person);
        person = new Person(10, "Bublik");

        long startTime = System.nanoTime();
        tree.insert(person);
        long endTime = System.nanoTime();
        System.out.println("Время выполнения вставки узла в дерево: " + (endTime - startTime));

        startTime = System.nanoTime();
        tree.find(10);
        endTime = System.nanoTime();
        System.out.println("Время поиска узла в дереве: " + (endTime - startTime));

        startTime = System.nanoTime();
        tree.inOrder(tree.root);
        endTime = System.nanoTime();
        System.out.println("Время обхода дерева: " + (endTime - startTime));

        startTime = System.nanoTime();
        tree.max();
        endTime = System.nanoTime();
        System.out.println("Время поиска максимума: " + (endTime - startTime));

        startTime = System.nanoTime();
        tree.min();
        endTime = System.nanoTime();
        System.out.println("Время поиска минимума: " + (endTime - startTime));

        startTime = System.nanoTime();
        tree.delete(7);
        endTime = System.nanoTime();
        System.out.println("Время удаления узла из дерева: " + (endTime - startTime));





    }
}
