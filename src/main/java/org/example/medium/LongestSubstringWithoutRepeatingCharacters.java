package org.example.medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int solution(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int max = 0;

        while (right <= s.length()-1) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, set.size());
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String input = "zxyzxyz";
        int result = solution(input);
        int expected = 3;

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}