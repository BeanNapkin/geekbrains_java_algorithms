public class Cat {

    String name;

    public Cat(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }

    public boolean compare(Cat cat) {
        return name.equals(cat.name);
    }
}

