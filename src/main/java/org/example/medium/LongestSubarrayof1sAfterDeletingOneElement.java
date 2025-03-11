package org.example.medium;

/**
 * <p>
 * Given a binary array nums, you should delete one element from it. <br>
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 * </p>
 *
 * <p>
 * <strong>Example 1</strong> <br>
 * Input: nums = [1,1,0,1] <br>
 * Output: 3 <br>
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * </p>
 *
 * <p>
 * <strong>Example 2</strong> <br>
 * Input: nums = [0,1,1,1,0,1,1,0,1] <br>
 * Output: 5 <br>
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * </p>
 *
 * <p>
 * <strong>Example 3</strong> <br>
 * Input: nums = [1,1,1] <br>
 * Output: 2 <br>
 * Explanation: You must delete one element. <br>
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/">
 * Longest Subarray of 1's After Deleting One Element
 * </a>
 */
public class LongestSubarrayof1sAfterDeletingOneElement {
    public int solution(int[] nums) {
        int solution = 0;
        int max = 0;
        boolean firstZero = false;
        int left = 0;


        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) max++;
            else if (firstZero) {
                // todo: meaning its secondZero -> check solution -> reset

                right = left;
                solution = Math.max(solution, max);
                max = 0;
                firstZero = false;
            }
            else if (left != right) {
                firstZero = true;
                left = right; // TODO : change the left into the 0's index
            }
            else {
                left++;
            }
        }

        solution = Math.max(solution, max);
        if (left == 0 && solution > 0) solution--; // TODO : this is for case where all is 1's
        return solution;
    }

}
