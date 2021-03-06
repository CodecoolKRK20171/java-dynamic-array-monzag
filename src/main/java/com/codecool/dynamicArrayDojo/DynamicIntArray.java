package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

public class DynamicIntArray {

    private int size;
    private int[] staticArray;

    public DynamicIntArray() {
        this.size = 0;
        this.staticArray = new int[this.size];
    }

    public DynamicIntArray(int size) {
        this.size = size;
        this.staticArray = new int[this.size];
    }

    public void add(int item) {
        this.size += 1;
        int[] tempArray = new int[this.size];
        System.arraycopy(staticArray, 0, tempArray, 0, this.size-1);
        this.staticArray = tempArray;
        this.staticArray[this.size-1] = item;
    }

    public void insert(int index, int item) {
        if (index <= this.size) {
            this.size += 1;
            int[] tempArray = new int[this.size];
            System.arraycopy(staticArray, 0, tempArray, 0, index);
            System.arraycopy(staticArray, index, tempArray, index + 1, this.size - 1 - index);
            this.staticArray = tempArray;
            this.staticArray[index] = item;
        } else {
            add(item);
        }
    }

    public void remove(int index) {
        this.size -= 1;
        int[] tempArray = new int[this.size];
        System.arraycopy(staticArray, 0, tempArray, 0, index);
        System.arraycopy(staticArray, index + 1, tempArray, index, this.size - index);
        this.staticArray = tempArray;
    }

    public String toString() {
        return " " + Arrays.toString(staticArray).replaceAll("(^\\[|\\]$|,)", "");
    }
}
