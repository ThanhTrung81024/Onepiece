package hus.oop.statistics;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    public MyArrayList() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(double value) {
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
    }

    @Override
    public void insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (size == data.length) {
            allocateMore();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        data[size] = 0;
    }

    @Override
    public MyArrayList sortIncreasing() {
        MyArrayList sorted = new MyArrayList();
        sorted.data = Arrays.copyOf(data, size);
        sorted.size = size;
        Arrays.sort(sorted.data, 0, sorted.size);
        return sorted;
    }

    @Override
    public int binarySearch(double key) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = data[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Override
    public MyIterator iterator(int start) {
        if (start < 0 || start > size) {
            throw new IndexOutOfBoundsException("Iterator start: " + start);
        }
        return new MyArrayListIterator(start);
    }

    private void allocateMore() {
        int newCap = data.length * 2;
        data = Arrays.copyOf(data, newCap);
    }

    private class MyArrayListIterator implements MyIterator {
        private int currentPosition;
        private boolean canRemove = false;

        public MyArrayListIterator(int position) {
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            canRemove = true;
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("next() not called or remove() already called");
            }
            int removeIndex = currentPosition - 1;
            MyArrayList.this.remove(removeIndex);
            currentPosition--;
            canRemove = false;
        }
    }
}
