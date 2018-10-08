package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    private int[] staticArray;

    public DynamicIntArray(int initialSize) {
        this.staticArray = new int[initialSize];
    }

    public DynamicIntArray() {
        this(0);
    }

    private void increaseCapacity(int newCapacity) {
        int[] newStaticArray = new int[newCapacity];

        for (int i = 0; i < newStaticArray.length; i++) {
            if (i < this.staticArray.length) {
                newStaticArray[i] = this.staticArray[i];
            }
            else {
                newStaticArray[i] = 0;
            }
        }
        this.staticArray = newStaticArray;
    }

    public void add(int number) {
        int size = this.staticArray.length;
        increaseCapacity(size + 1);
        this.staticArray[size] = number;
    }

    public void remove(int element) {
        int size = this.staticArray.length;
        for (int i = 0; i < size; i++) {
            if (element == this.staticArray[i]) {
                int numMoved = size - i - 1;
                System.arraycopy(this.staticArray, i + 1, this.staticArray, i, numMoved);
            }
        }
        increaseCapacity(--size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int number : this.staticArray) {
            builder.append(" ");
            builder.append(number);
        }
        return builder.toString();
    }

}
