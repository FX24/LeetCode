package org.example.medium;

public class FindMinimumInRotatedSortedArray {
    public static int solution(int[] nums) {
        int right = nums.length-1;
        int left = 0;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check left sorted
            if (nums[mid] >= nums[left]) {
                // Check if left-right sorted -> take leftMost number as min
                if (nums[mid] < nums[right]) min = Math.min(min, nums[left]);
                left = mid + 1;
            }
            else right = mid - 1;
            min = Math.min(min, nums[mid]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,5,6,7,0,1,2};
        int result = solution(input);
        int expected = 0;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}