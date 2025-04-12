package org.example.medium;

import org.example.model.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean solution(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> permutationMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        // Put target permutation in Map
        for (char c : s1.toCharArray()) {
            permutationMap.put(c, permutationMap.getOrDefault(c, 0) + 1);
        }

        int need = permutationMap.size();
        int lenPermutation = s1.length();
        int lenString = s2.length();

        // Insert target into map
        for (int curr = 0; curr < lenPermutation; curr++) {
            char currChar = s2.charAt(curr);
            targetMap.put(currChar, targetMap.getOrDefault(currChar, 0) + 1);
        }

        // Iterate from index 0 -> n-lenTarget
        int start = 0;
        int end = lenPermutation - 1;
        do {
            if (isFoundPermutation(permutationMap, targetMap)) return true;
            else if (end == lenString-1) return false;
            else {
                targetMap.put(s2.charAt(start), targetMap.get(s2.charAt(start)) - 1);
                targetMap.put(s2.charAt(end+1), targetMap.getOrDefault(s2.charAt(end+1), 0) + 1);
            }

            end++;
            start++;

        } while (end < lenString);
        return false;
    }

    public static boolean isFoundPermutation(Map<Character, Integer> permutationMap, Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> permutationEntry : permutationMap.entrySet()) {
            Character currCheck = permutationEntry.getKey();
            if (!targetMap.getOrDefault(currCheck, 0).equals(permutationEntry.getValue())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "lecabee";
        boolean result = solution(s1, s2);
        boolean expected = true;

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}