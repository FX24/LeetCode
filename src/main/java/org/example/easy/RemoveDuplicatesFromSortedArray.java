package org.example.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150">
 * Remove Duplicates from Sorted Array
 * </a>
 */
public class RemoveDuplicatesFromSortedArray {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int nextExistIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (set.add(number)) {
                nums[nextExistIndex] = number;
                nextExistIndex++;
            }
        }
        return set.size();
    }
}