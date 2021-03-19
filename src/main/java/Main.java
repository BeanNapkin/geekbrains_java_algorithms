import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] arrTest) {
//        int integer = 1;
//        String string = "Строка";
//        Cat barsik = new Cat("Барсик");
//
//        System.out.println(integer);
//        System.out.println(string);
//        barsik.print();

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        long startTime = System.nanoTime();
//        System.out.println(isIntegerEqualsAnyElementInArray(integer, arr));
        long endTime = System.nanoTime();
//        System.out.println("Время выполнения сравнения чисел: " + (endTime - startTime));
//
//        String[] arrStrings = {"Строка", "Число"};
//        startTime =  System.nanoTime();
//        System.out.println(isStringEqualsAnyElementInArray(string, arrStrings));
//        endTime = System.nanoTime();
//        System.out.println("Время выполнения сравнения строк: " + (endTime - startTime));
//
//        Cat korgyk = new Cat("Коржик");
//        startTime =  System.nanoTime();
//        System.out.println(barsik.compare(korgyk));
//        endTime = System.nanoTime();
//        System.out.println("Время выполнения сравнения объектов по именам: " + (endTime - startTime));


        // Задание 2

        arr = fillArray(10);

        startTime = System.nanoTime();
        System.out.println(Arrays.toString(arr));
        endTime = System.nanoTime();
        System.out.println("Время выполнения вывода массива в консоль как строки: " + (endTime - startTime));

        startTime = System.nanoTime();
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        endTime = System.nanoTime();
        System.out.println("Время выполнения копирования массива: " + (endTime - startTime));

        startTime = System.nanoTime();
        Arrays.equals(arr, arrCopy);
        endTime = System.nanoTime();
        System.out.println("Время выполнения сравнения массивов: " + (endTime - startTime));

        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int toFind = 2;

        startTime = System.nanoTime();
        linearSearch(arr2, toFind);
        endTime = System.nanoTime();
        System.out.println("Время выполнения линейного поиска: " + (endTime - startTime));

        startTime = System.nanoTime();
        binarySearch(arr2, toFind);
        endTime = System.nanoTime();
        System.out.println("Время выполнения бинарного поиска: " + (endTime - startTime));

        int[] arr3 = fillArray(400);
        int[] arr3Copy = Arrays.copyOf(arr3, arr3.length);
        int[] arr4Copy = Arrays.copyOf(arr3, arr3.length);
        int[] arr5Copy = Arrays.copyOf(arr3, arr3.length);
        startTime = System.nanoTime();
        Arrays.sort(arr3);
        endTime = System.nanoTime();
        System.out.println("Время выполнения сортировки методом sort(): " + (endTime - startTime));


        startTime = System.nanoTime();
        sortByBubble(arr3Copy);
        endTime = System.nanoTime();
        System.out.println("Время выполнения сортировки методом пузырька: " + (endTime - startTime));

        startTime = System.nanoTime();
        selectionSorting(arr4Copy);
        endTime = System.nanoTime();
        System.out.println("Время выполнения сортировки методом выбора: " + (endTime - startTime));

        startTime = System.nanoTime();
        insertionSort(arr5Copy);
        endTime = System.nanoTime();
        System.out.println("Время выполнения сортировки методом вставки: " + (endTime - startTime));

    }


    public static boolean isIntegerEqualsAnyElementInArray(int integer, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (integer == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStringEqualsAnyElementInArray(String string, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (string.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public static int[] fillArray(int count) {
        int[] arr = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static int linearSearch(int[] arr, int toFind) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                index = i;
            }
        }
        return index;
    }

    public static int binarySearch(int[] arr, int toFind) {
        int index = -1;

        int first = 0;
        int last = arr.length - 1;

        while (first <= last) {

            int middle = (last + first) / 2;

            if (arr[middle] == toFind) {
                index = middle;
                break;
            } else if (arr[middle] > toFind) {
                last = middle - 1;
            } else if (arr[middle] < toFind) {
                first = middle + 1;
            }
        }
        return index;
    }

    public static int[] sortByBubble(int[] arr) {
        boolean isElementsSorted = false;

        int temp;

        while (!isElementsSorted) {
            isElementsSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isElementsSorted = false;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSorting(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        return arr;
    }
}
