package com.yuriyni.dsa.top_interview_150;

import java.util.HashMap;
import java.util.HashSet;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
//        int[] nums = {3,2,3};
//        int[] nums = {6,5,5};
        System.out.println("majorityElement >> "+majorityElement( nums ));
    }

    public static int majorityElement(int[] nums) {
        int n=nums.length;
        int c = n / 2;

        int  majorityElement = 0;
        int tempVar=0;
        int loopCount=0;
        HashMap hs = new HashMap();
        for(int i=0; i<n;i++){
            tempVar = nums[i];

            if(!hs.containsKey(tempVar)){
                hs.put(nums[i],"");
                for(int j=i; j<n;j++){
                    System.out.println("nums[i] == nums[j] >>> where i="+i+" and j="+j+", "+nums[i] +", "+ nums[j]);
                    if(nums[i] == nums[j]){
                        loopCount++;
                    }
                }
            }

            System.out.println("hs.containsKey(tempVar)="+hs.containsKey(tempVar)+", c="+c+", nums[i] = "+nums[i]+" where [i]="+i+", loopCount= "+loopCount);
            if(loopCount > c){
                majorityElement = nums[i];
            }

            loopCount=0;

            System.out.println();
        }
        return majorityElement;
    }
}
