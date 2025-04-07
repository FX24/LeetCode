package org.example.medium;

import java.util.HashSet;

public class LongestRepeatingCharacterReplacement {
    public static int solution(String s, int k) {
        int replacement = k;
        int left = 0, right = 0;
        int max = 0;
        int currMax = 0;
        Character target = s.charAt(left);

        while (right <= s.length()-1) {
            if (s.charAt(right) != target) {
                // Move left -> first occurance where character different with target
                if (replacement == k) {
                    left = right;
                }
                // Keep moving if replacement > 0 with decreasing replacement value
                if (replacement > 0) {
                    right++;
                    replacement--;
                    currMax++;
                    max = Math.max(max,currMax);
                }
                // Reset right -> left
                else {
                    target = s.charAt(left);
                    currMax = 0;
                    right = left;
                    replacement = k;
                }
            }
            // Keep Moving
            else {
                right++;
                currMax++;
                max = Math.max(max,currMax);
            }
        }

        // Check for last substring, if replacement still > 0, use it as max
        if (replacement > 0) {
            currMax = (currMax + replacement > s.length() ? s.length() : currMax + replacement);
            max = Math.max(max, currMax);
        }
        return max;
    }

    public static void main(String[] args) {
        String input = "AAABABB";
        int k = 2;
        int result = solution(input, k);
        int expected = 5;

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}