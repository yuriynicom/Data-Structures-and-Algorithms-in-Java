package com.yuriyni.dsa.backtracking;
// important import statements

import java.util.Collections;
import java.util.ArrayList;

public class SubsetIntArr {

    // method that displays all the subsets with the help of the method getSubsets
    public void displayAllSubsets(int s, ArrayList<Integer> inputArrList) {

        // 2D list for keeping all the subset found answer
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        // a temporary list for keeping the current subset
        ArrayList<Integer> tmp = new ArrayList<>();

        // the first call to the recursive method
        getSubsets(0, tmp, answer, inputArrList);

        // Printing the final answer
        for (int i = 0; i < answer.size(); i++) {
            // Sorting and printing each subset
//            Collections.sort(answer.get(i));
            System.out.print("[ ");
            for (int j = 0; j < answer.get(i).size(); j++) {
                System.out.print(answer.get(i).get(j) + " ");
            }
            System.out.print("]");
            System.out.println();
        }

    }

    // a method that generates all the subsets of the input list
    private void getSubsets(int i, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> inputArrList) {

        // handling the base case
        if (i == inputArrList.size()) {
            // including the generated current subset (which is non empty) to the 2D list answer
            if (tmp.size() > 0) {
                answer.add(tmp);
            }
            return;
        }

        // Invoking the subset that has the ith array element inside it
        ArrayList<Integer> tmp1 = new ArrayList<>(tmp);
        tmp1.add(inputArrList.get(i));
        getSubsets(i + 1, tmp1, answer, inputArrList);

        // Generating the subset that will not contain the ith array element
        getSubsets(i + 1, tmp, answer, inputArrList);
    }

    // main method
    public static void main(String argvs[]) {

        // creating an object of the class SubsetIntArr
        SubsetIntArr obj = new SubsetIntArr();

        // creating an object of the class ArrayList
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        // input 1
        for (int j = 1; j <= 3; j++) {
            arrList.add(j);
        }

        System.out.println("For the array list: " + arrList + " \n");

        System.out.println("The subsets are: ");

        obj.displayAllSubsets(arrList.size(), arrList);

        System.out.println();

        arrList.clear();

//// input 2
//        for (int j = 1; j <= 5; j++) {
//            arrList.add(j);
//        }
//
//        System.out.println("For the array list: " + arrList + " \n");
//
//        System.out.println("The subsets are: ");
//
//        obj.displayAllSubsets(arrList.size(), arrList);
//
//
    }
}