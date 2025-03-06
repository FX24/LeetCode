package org.example.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence {

    public static int solution(int[] nums) {
        /*
         * The idea is :
         * - Add to hash set for all num
         * - Check for every number in set if it is starting number (doesn't have n-1 in set)
         * - Iterate through n+1 and get those maxSequence
         * - Compare current max and maxSequence
         * - Result in max
         * */

        HashSet<Integer> numSet = new HashSet<>();
        int max = 0;


        // Add into set
        for (int number : nums) {
            numSet.add(number);
        }

        // Iterate through all set
        for (Integer number : numSet) {

            // Get the start number (doesn't have n-1 in set)
            int prevNumber = number - 1;

            if (!numSet.contains(prevNumber)) {
                int maxSeq = 1;
                int nextNumber = number + 1;

                while (numSet.contains(nextNumber)) {
                    maxSeq++;
                    nextNumber++;
                }

                max = Math.max(maxSeq, max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2,20,4,10,3,4,5};
        int output = 4;
        int result = solution(input);

        System.out.println("Output : " + output);
        System.out.println("Result : " + result);
    }
}