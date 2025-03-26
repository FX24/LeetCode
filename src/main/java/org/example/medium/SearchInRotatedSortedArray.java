package org.example.medium;

public class SearchInRotatedSortedArray {
    public static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Left sorted
            if (nums[mid] >= nums[left]) {

                // Check if target is not in left array
                if (inNotRange(target, left, mid, nums)) left = mid + 1;
                else right = mid;

                if (target == nums[mid]) return mid;
            }

            // Right sorted
            else {
                if (inNotRange(target, mid, right, nums)) right = mid - 1;
                else left = mid;
            }
        }

        return -1;
    }

    private static boolean inNotRange(int target, int left, int right, int[] nums) {
        return !(target >= nums[left] && target <= nums[right]);
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int result = solution(input, target);
        int expected = 4;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}