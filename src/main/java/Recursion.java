import java.util.Arrays;

public class Recursion {
    public static void main(String[] arrTest) {
        // Задание 5.2 - Бесконечная рекурсия и рекурсия с условием выхода
        endlessRecursion();
        recursionWithEnd(5);

        // Задание 5.4 - Сравнение простого алгоритма с циклом и с рекурсией
        long startTime = System.nanoTime();
        simpleAlgorithmWithCycle(2, 1000);
        long endTime = System.nanoTime();
        System.out.println("Время выполнения простого алгоритма с циклом: " + (endTime - startTime));

        startTime = System.nanoTime();
        simpleAlgorithmWithRecursion(2, 1000);
        endTime = System.nanoTime();
        System.out.println("Время выполнения простого алгоритма с рекурсией: " + (endTime - startTime));

        // Задание 5.5 - Сравнение двоичного рекурсивного поиска и обычного
        int[] arr = {0, 3, 8, 10, 12, 15, 18, 23, 38};
        startTime = System.nanoTime();
        binarySearch(arr, 8);
        endTime = System.nanoTime();
        System.out.println("Время выполнения обычного двоичного поиска: " + (endTime - startTime));

        startTime = System.nanoTime();
        binaryRecursionSearch(arr, 8, 0, arr.length - 1);
        endTime = System.nanoTime();
        System.out.println("Время выполнения рекурсивного двоичного поиска: " + (endTime - startTime));

        // Задание 5.6 - Сравнение сортировки массива слиянием и методом sort
        int[] arr2 = {5, 9, 1, 100, 17, 88, 99, 123, 13, 2, 0};
        startTime = System.nanoTime();
        Arrays.sort(arr2);
        endTime = System.nanoTime();
        System.out.println("Время сортировки массива методом sort: " + (endTime - startTime));

        startTime = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        endTime = System.nanoTime();
        System.out.println("Время сортировки массива слиянием: " + (endTime - startTime));

    }

    public static void endlessRecursion() {
        try {
            endlessRecursion();
        } catch (StackOverflowError e) {
        }
    }

    public static void recursionWithEnd(int n) {
        if (n >= 0) {
            recursionWithEnd(n - 1);
        }
    }

    public static int simpleAlgorithmWithCycle(int k, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * k;
        }
        return result;
    }

    public static int simpleAlgorithmWithRecursion(int k, int n) {
        int result = k;

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return result;
        }
        return result * simpleAlgorithmWithCycle(k, n - 1);
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

    public static int binaryRecursionSearch(int[] arr, int toFind, int first, int last) {

        final int notFound = -1;

        if (last - first == 1) {
            if (arr[first] == toFind) {
                return first;
            } else if (arr[last] == toFind) {
                return last;
            } else {
                return notFound;
            }
        }

        if (last > first) {

            int middle = (last + first) / 2;

            if (arr[middle] == toFind) {
                return middle;
            } else if (arr[middle] > toFind) {
                return binaryRecursionSearch(arr, toFind, first, middle);
            } else if (arr[middle] < toFind) {
                return binaryRecursionSearch(arr, toFind, middle, last);
            }

        }
        return notFound;
    }


    public static void mergeSort(int[] arr, int first, int last) {

        if (last <= first)
            return;
        int middle = first + (last - first) / 2;
        mergeSort(arr, first, middle);
        mergeSort(arr, middle + 1, last);

        int[] buf = Arrays.copyOf(arr, arr.length);

        for (int k = first; k <= last; k++)
            buf[k] = arr[k];

        int i = first;
        int j = middle + 1;
        for (int k = first; k <= last; k++) {

            if (i > middle) {
                arr[k] = buf[j];
                j++;
            } else if (j > last) {
                arr[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                arr[k] = buf[j];
                j++;
            } else {
                arr[k] = buf[i];
                i++;
            }
        }
    }
}
