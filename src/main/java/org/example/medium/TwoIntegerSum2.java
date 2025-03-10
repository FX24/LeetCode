package org.example.medium;

import java.util.Arrays;

public class TwoIntegerSum2 {
    public static int[] solution(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum < target) left++;
            else if (sum > target) right--;
            else break;
        }
        return new int[]{left+1, right+1};
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4};
        int target = 3;
        int[] result = solution(input, target);
        int[] expected = new int[]{1,2};

        System.out.println("Result : " + Arrays.toString(result));
        System.out.println("Expected : " + Arrays.toString(expected));
    }
}