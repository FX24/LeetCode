package org.example.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int arrLen = nums.length;

        for (int i=0; i<arrLen; i++){
            int target = nums[i];
            int left = i+1;
            int right = arrLen-1;

            if (i > 0 && target == nums[i-1]) continue;
            if (target > 0) break;

            while (left < right) {
                int numLeft = nums[left];
                int numRight = nums[right];
                int sum = target + numLeft + numRight;

                if (sum < 0) left++;
                if (sum > 0) right--;
                if (sum == 0) {
                    result.add(List.of(target, numLeft, numRight));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = solution(input);
        List<List<Integer>> expected = List.of(
                List.of(-1,-1,2),
                List.of(-1,0,1)
        );

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}