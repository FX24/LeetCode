package org.example.easy;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/?envType=study-plan-v2&envId=top-interview-150">
 * Longest Common Prefix
 * </a>
 */
public class LongestCommonPrefix {
    public String solution(String[] strs) {
        String prefix = strs[0];

        //TODO: LOOP string list
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int counter = Math.min(str.length(), prefix.length());

            //TODO: Compare prefix with the string
            for (int j = 0; j < counter; j++) {
                //TODO: Character is not same -> this is longest prefix for compared string
                if (str.charAt(j) != prefix.charAt(j)) {
                    if (j == 0) return "";
                    prefix = prefix.substring(0, j);
                }

                if (j == counter-1) {
                    if (j == 0) prefix=prefix.substring(0,1);
                    else prefix = prefix.substring(0,j);
                }
            }
        }
        return prefix;
    }
}