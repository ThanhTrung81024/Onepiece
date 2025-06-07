package hus.oop.sortstrategy;

public class InsertionSort implements ISort {
    @Override
    public int sort(int[] data) {
        int n = data.length;
        int swapCount = 0;
        for (int i = 1; i < n; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
                swapCount++;
            }
            data[j + 1] = key;
        }
        return swapCount;
    }
}
