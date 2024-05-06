package com.yuriyni.dsa.top_interview_150;

import java.util.Arrays;

/**
 * RemoveElement
 * //https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
 */

 public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int[] expectedNums = new int[nums.length];

        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                expectedNums[k] = nums[i];
                k++;
            }
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = expectedNums[i];
        }

//        Arrays.stream(expectedNums).forEach(System.out::print);
        Arrays.stream(nums).forEach(System.out::print);

        return k;

    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val=3;
        removeElement( nums,   val);
//        System.out.println();
    }
}
