package com.yuriyni.dsa.sorting;

import java.util.Arrays;

// просто по памяти пишу код
public class BubbleSort2 {
    public static void main(String[] args) {
        int arr[] = {44,1,55,66,47,87,12,45,76,91,49,20,31,45,81,23};

        boolean isSorted = false;
        while(!isSorted) {
            isSorted=true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    isSorted = false;
                }
            }
        }

        Arrays.stream(arr).forEach(arrValue -> {System.out.print(arrValue+",");});
    }
}
