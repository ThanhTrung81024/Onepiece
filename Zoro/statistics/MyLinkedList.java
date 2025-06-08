package hus.oop.statistics;

import java.util.Arrays;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    public MyLinkedList() {
        top = null;
    }

    @Override
    public int size() {
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void add(double value) {
        MyNode newNode = new MyNode(value);
        if (top == null) {
            top = newNode;
        } else {
            MyNode current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    @Override
    public void insert(double value, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        MyNode newNode = new MyNode(value);
        if (index == 0) {
            newNode.next = top;
            top = newNode;
        } else {
            MyNode prev = getNodeByIndex(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            top = top.next;
        } else {
            MyNode prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        int n = size();
        double[] arr = new double[n];
        MyNode current = top;
        for (int i = 0; i < n; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        Arrays.sort(arr);
        MyLinkedList sorted = new MyLinkedList();
        for (double v : arr) {
            sorted.add(v);
        }
        return sorted;
    }

    @Override
    public int binarySearch(double key) {
        int n = size();
        double[] arr = new double[n];
        MyNode current = top;
        for (int i = 0; i < n; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        int idx = Arrays.binarySearch(arr, key);
        return idx >= 0 ? idx : -1;
    }

    @Override
    public MyIterator iterator(int start) {
        if (start < 0 || start > size()) {
            throw new IndexOutOfBoundsException("Iterator start: " + start);
        }
        return new MyLinkedListIterator(start);
    }

    private MyNode getNodeByIndex(int index) {
        MyNode current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        private MyNode nextNode;
        private MyNode lastReturned;
        private int nextIndex;
        private boolean canRemove;

        public MyLinkedListIterator(int position) {
            this.nextNode = (position == 0) ? top : getNodeByIndex(position);
            this.nextIndex = position;
            this.lastReturned = null;
            this.canRemove = false;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            lastReturned = nextNode;
            nextNode = nextNode.next;
            nextIndex++;
            canRemove = true;
            return lastReturned.data;
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("next() not called or remove() already called");
            }
            MyLinkedList.this.remove(nextIndex - 1);
            nextIndex--;
            canRemove = false;
        }
    }
}
