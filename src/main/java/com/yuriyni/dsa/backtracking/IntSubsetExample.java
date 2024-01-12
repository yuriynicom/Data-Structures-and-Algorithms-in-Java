package com.yuriyni.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IntSubsetExample {
    public static void main(String[] args) {
        List<List<Integer>> lists = subsets(new int[]{1, 2, 3});

//        lists.stream().forEach(subset -> {
//            System.out.println(subset);
//        });
    }

    // Solution by Google Bard https://aipromptoverflow.com/question/backtracking-java-samples-determine-all-subset/
    public static List<List<Integer>> subsets(int[] nums) {
        System.out.println("*************************");
        System.out.println("STARTING....");
        System.out.println("*************************");
        List<List<Integer>> allSubsets = new ArrayList<>();
        System.out.println("init ... Array of subsets and call it ALL_SUB_SETS   " + allSubsets + "");
        allSubsets.add(new ArrayList<>()); // Add first empty subset
        System.out.println("Add first empty subset to ALL_SUB_SETS " + allSubsets + "");
        for (int num : nums) {
            System.out.println("****** START OF FOR OUTER *******");
            System.out.println("num="+num+", and it is next value array [1,2,3]");
            int n = allSubsets.size();
            System.out.println("n="+n+", and it is current ALL_SUB_SETS size()");

            for (int i = 0; i < n; i++) {
                System.out.println("     ****** START OF INNER loop *******");
                System.out.println("     i=" + i + ", and it is inner loop ind");

                System.out.println("     1 >>> get(i), ALL_SUB_SETS.get(" + i + "):" + allSubsets.get(i) + "");
                List<Integer> newSubset = new ArrayList<>(allSubsets.get(i));

                System.out.println("     2 >>> newSubset created:" + newSubset + "");
                System.out.println("     num = " + num + ", adding to newSubset .... ");
                newSubset.add(num);

                System.out.println("     3 >>> num added newSubset:" + newSubset + "");
                allSubsets.add(newSubset);
                System.out.println("     4 >>> newSubset added to ALL_SUB_SETS:" + allSubsets + "");

                System.out.println("     ****** END OF INNER loop *******");
            }
            System.out.println("****** END OF FOR OUTER *******");
            System.out.println(" ");
            System.out.println("LET`S CHECK current ALL_SUB_SETS:" + allSubsets + ". And its size is "+allSubsets.size());
            System.out.println(" ");
        }

        return allSubsets;
    }

}