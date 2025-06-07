package hus.oop.sortstrategy;
import java.util.*;

public class App {
    public static void main(String[] args) {
        /* TODO */
        // Tạo một mảng các số tự nhiên, các số tự nhiên được sinh ngẫu nhiên
        // In ra mảng vừa tạo theo định dạng, ví dụ [1 2 3 4 5].
        // Sắp xếp mảng theo thứ tự tăng dần sử dụng các thuật toán sắp xếp khác nhau.
        // In ra mảng sau khi sắp xếp.
        // In ra số lần đổi vị trí trong thuật toán đang sử dụng.
        // Ví dụ:
        // Using Bubble Sort Algorithm:
        // Before sorting: [5 4 3 2 1]
        // After sorting: [1 2 3 4 5]
        // Number of swap: 10
        // Tạo một mảng các số tự nhiên
        int[] data = generateRandomArray(10, 1, 100); // Tạo mảng 10 số từ 1 đến 100
        int[] originalData = Arrays.copyOf(data, data.length); // Tạo bản sao của mảng

        // In ra mảng vừa tạo theo định dạng, ví dụ [1 2 3 4 5].
        System.out.println("Before sorting: " + Arrays.toString(data));

        // Sắp xếp mảng theo thứ tự tăng dần sử dụng các thuật toán sắp xếp khác nhau.
        sortAndPrint(data, "Bubble Sort");
        sortAndPrint(data, "Selection Sort");
        sortAndPrint(data, "Insertion Sort");

        // In ra mảng sau khi sắp xếp.
        System.out.println("Original array after sorting: " + Arrays.toString(originalData));
    }

    public static void sortAndPrint(int[] data, String algorithm) {
        ISort sorter = getSorter(algorithm);
        int[] sortedData = Arrays.copyOf(data, data.length); // Tạo bản sao của mảng trước khi sắp xếp
        int swapCount = sorter.sort(sortedData);

        // In ra mảng sau khi sắp xếp
        System.out.println("Using " + algorithm + " Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(data));
        System.out.println("After sorting: " + Arrays.toString(sortedData));
        System.out.println("Number of swaps: " + swapCount);
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static ISort getSorter(String algorithm) {
        switch (algorithm) {
            case "Bubble Sort":
                return new BubbleSort();
            case "Selection Sort":
                return new SelectionSort();
            case "Insertion Sort":
                return new InsertionSort();
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm: " + algorithm);
        }
    }
}
