package org.example.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String solution(String s, String t) {
        // You may assume that the correct output is always unique.
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> stringMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        String minString = "";
        int left = 0;
        int right = 0;

        // Insert input map
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Base class
        stringMap.put(s.charAt(0), 1);

        // Iterate till last string
        while (right < s.length()) {
            int currLen = right - left + 1;

            // Substring not found String
            if (!isSubstring(stringMap, targetMap)) {
                right++;
                if (right < s.length()) stringMap.put(s.charAt(right), stringMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            // Substring found with currLen is lower than min
            else if (currLen < min) {
                min = currLen;
                minString = s.substring(left, right + 1);
                stringMap.put(s.charAt(left), stringMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            // Substring found but currLen is higher than min
            else {
                stringMap.put(s.charAt(left), stringMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }

        return minString;
    }

    public static boolean isSubstring(Map<Character, Integer> stringMap, Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> targetEntry : targetMap.entrySet()) {
            Character currCheck = targetEntry.getKey();
            if (stringMap.getOrDefault(currCheck, 0) < targetEntry.getValue()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "OUZODYXAZV";
        String substring = "XYZ";
        String result = solution(input, substring);
        String expected = "YXAZ";

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}