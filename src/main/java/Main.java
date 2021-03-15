public class Main {
    public static void main(String[] args) {
        int integer = 1;
        String string = "Строка";
        Cat barsik = new Cat("Барсик");

        System.out.println(integer);
        System.out.println(string);
        barsik.print();

        int[] arr = {10,9,8,7,6,5,4,3,2,1};

        long startTime =  System.nanoTime();
        System.out.println(isIntegerEqualsAnyElementInArray(integer, arr));
        long endTime = System.nanoTime();
        System.out.println("Время выполнения сравнения чисел: " + (endTime - startTime));

        String[] arrStrings = {"Строка", "Число"};
        startTime =  System.nanoTime();
        System.out.println(isStringEqualsAnyElementInArray(string, arrStrings));
        endTime = System.nanoTime();
        System.out.println("Время выполнения сравнения строк: " + (endTime - startTime));

        Cat korgyk = new Cat("Коржик");
        startTime =  System.nanoTime();
        System.out.println(barsik.compare(korgyk));
        endTime = System.nanoTime();
        System.out.println("Время выполнения сравнения объектов по именам: " + (endTime - startTime));

    }

    public static boolean isIntegerEqualsAnyElementInArray(int integer, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (integer == arr[i]){
                return true;
            }
        }
        return false;
    }

    public static boolean isStringEqualsAnyElementInArray(String string, String[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (string.equals(arr[i])){
                return true;
            }
        }
        return false;
    }
}
