package com.yuriyni.dsa.sorting;

import java.util.Arrays;

/**
 * Java. Быстрая сортировка. Объяснение на пальцах)
 * https://www.youtube.com/watch?v=CeHJV4zu_Ts&list=PL5BhKu-LkR_0mDGftRWeaakqGuYE1ToGG&index=5
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] array = {64,42,73,41,32,53,16,24,57,42,74,55,36};
        System.out.println(arrayToString(array));
        quickSort (array,0,array.length-1);
    }

    private static void quickSort(int [] arr, int from, int to){
        if(from<to){
            int divideIndex = partition(arr,from,to);
            printSortStep(arr,from,to,divideIndex);
            quickSort(arr,from,divideIndex-1);
            quickSort(arr,divideIndex,to);
        }
    }

    private static int partition(int [] arr, int from, int to){
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from];
        while(leftIndex<=rightIndex){

            while(arr[leftIndex] < pivot){
                leftIndex++;
            }

            while(arr[rightIndex] > pivot){
                rightIndex--;
            }

            if(leftIndex <= rightIndex){
                swap(arr, rightIndex,leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;

    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp  = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }
}
