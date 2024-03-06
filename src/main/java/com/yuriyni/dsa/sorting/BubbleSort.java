package com.yuriyni.dsa.sorting;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 *     bubble sort algorithm
 *     алгоритм сортировки пузырьком
 *     https://youtu.be/aXyMkR8LGEo?si=SOCaoFfpg5b4vhtp
 */
public class BubbleSort {

    public static void main(String[] args) {
        int array[] = new int[]{
                64, 42, 73, 41, 31, 53, 16, 24, 57, 57, 52, 74, 55, 36
        };

        printArray(array);

        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            //if left item is over the right element we replace them
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
            printArray(array);
        }
    }

    private static void printArray(int [] arr){
        Arrays.stream(arr).forEach(e-> System.out.print(e+","));
        System.out.println();
    }
}
