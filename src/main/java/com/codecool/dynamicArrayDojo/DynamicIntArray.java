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

    public void remove(int index) {
        int size = this.staticArray.length;
        int numMoved = size - index - 1;

        System.arraycopy(this.staticArray, index + 1, this.staticArray, index, numMoved);
        increaseCapacity(--size);
    }

    public void insert(int index, int number) {
        int size = this.staticArray.length;

        if (index <= size) {
            increaseCapacity(size + 1);
            System.arraycopy(this.staticArray, index, this.staticArray, index + 1, size - index);
            this.staticArray[index] = number;
        }
        else {
            add(number);
        }
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
