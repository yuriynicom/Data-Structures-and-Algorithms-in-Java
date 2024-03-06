package com.yuriyni.dsa.sorting;

/**
 * Algorithm to find minimum element in array
 * поиск минимального элемента массива и его позицию
 * https://youtu.be/J8CbZYnJ5O8?si=WDMXuzv2LBbc9_kv
 */
public class Main {


    public static void main(String[] args) {
        int array[] = new int[]{
                64, 42, 73, 41, 31, 53, 16, 24, 57, 57, 52, 74, 55, 36
        };

        int minValue = array[0];
        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }

        System.out.println("min value: " + minValue);
        System.out.println("min index: " + minIndex);
    }
}
