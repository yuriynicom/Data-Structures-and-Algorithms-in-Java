package com.yuriyni.dsa.top_interview_150;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class BestTimeToBuyAndSellStock {

    /**
     * LeetCode #:121 Best Time to Buy and Sell Stock
     * https://www.youtube.com/watch?v=ioFPBdChabY
     *
     */
    public static int maxProfit(int[] prices){
        int profit=0;
        int buy = prices[0];

        for(int i=1; i<prices.length; i++)
        {
            int sell = prices[i];

            if(buy<sell){
                profit = Math.max(profit,sell-buy);
            }else{
                buy = sell;
            }
        }

        return profit;
    }


    //too slow
    public static int maxProfit2(int[] prices) {

        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i; j < prices.length; j++) {
                int cell = prices[j];
                if (buy < cell) {
                    if ((cell - buy) > profit) {
                        profit = cell - buy;
                    }
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new Date());
        String fileName = "data.txt";

        try {
//        int[] prices = {2, 4, 1};
//        int[] prices =  {7,6,4,3,1 };
//        int[] prices = {7,1,5,3,6,4};
            int[] prices = readFile(fileName) ;

//            for(int i:prices)
//                System.out.println(i);

            System.out.println(maxProfit(prices));
        } catch ( Exception e) {
            e.printStackTrace();
        }
        System.out.println(new Date());
    }

    public static int[] readFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            // Split the line using StringTokenizer (comma as delimiter)
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine() , ",");
            int[] intArray = new int[tokenizer.countTokens()];  // Determine array size

            int index = 0;
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken().trim();  // Remove leading/trailing spaces
                try {
                    int value = Integer.parseInt(token);
                    intArray[index++] = value;
                } catch (NumberFormatException e) {
                    // Handle invalid integer format (optional: throw exception, log error, etc.)
                    System.err.println("Error parsing integer: " + token);
                }
            }


            return intArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
