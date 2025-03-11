package org.example.hard;

public class TrappingRainWater {
    public static int solution(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int maxLeft = height[left];
        int maxRight = height[right];

        // Iterate both pointer
        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                int numLeft = height[left];
                maxLeft = Math.max(maxLeft, numLeft);
                result += maxLeft - numLeft;
            } else {
                right--;
                int numRight = height[right];
                maxRight = Math.max(maxRight, numRight);
                result += maxRight - numRight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,2,0,3,1,0,1,3,2,1};
        int result = solution(input);
        int expected = 9;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}