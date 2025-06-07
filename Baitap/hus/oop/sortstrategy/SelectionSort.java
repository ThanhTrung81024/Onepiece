package hus.oop.sortstrategy;

public class SelectionSort implements ISort {
    @Override
    public int sort(int[] data) {
        /* TODO */
        int n = data.length;
        int swapCount = 0;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap data[i] và data[minIndex]
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
            swapCount++;
        }
        return swapCount;
    }
}
