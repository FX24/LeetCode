package org.example.medium;

public class ContainerWithMostWater {
    public static int solution(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int max = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(max, area);

            if (heights[left] <= heights[right]) left++;
            else right--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,7,2,5,4,7,3,6};
        int result = solution(input);
        int expected = 36;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}