import java.util.Random;

public class PyramidSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        long startTime = System.nanoTime();
        heapSort(arr);
        long endTime = System.nanoTime();

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Время выполнения пирамидальной сортировки: " + (endTime - startTime));
    }

    public static void siftDown(int[] numbers, int root, int bottom) {
        int maxChild;
        boolean isPyramidDone = false;

        while ((root * 2 <= bottom) && (!isPyramidDone)) {
            if (root * 2 == bottom) {
                maxChild = root * 2;
            } else if (numbers[root * 2] > numbers[root * 2 + 1]) {
                maxChild = root * 2;
            } else {
                maxChild = root * 2 + 1;
            }

            if (numbers[root] < numbers[maxChild]) {
                int temp = numbers[root];
                numbers[root] = numbers[maxChild];
                numbers[maxChild] = temp;
                root = maxChild;
            } else {
                isPyramidDone = true;
            }
        }
    }

    public static void heapSort(int[] numbers) {

        for (int i = (numbers.length / 2); i >= 0; i--)
            siftDown(numbers, i, numbers.length - 1);

        for (int i = numbers.length - 1; i >= 1; i--) {
            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;
            siftDown(numbers, 0, i - 1);
        }
    }
}
