package exercise;

import java.util.ArrayList;

class SafetyList {
    // BEGIN
    private int[] elements = new int[10000];
    private int size = 0;

    public synchronized void add(int element) {
        elements[size++] = element;
    }

    public synchronized int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + "is out of bounds for size " + size);
        }
        return elements[index];
    }
    public synchronized int getSize() {
        return size;
    }

    // END
}
