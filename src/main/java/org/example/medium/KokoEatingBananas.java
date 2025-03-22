package org.example.medium;

import java.util.Arrays;

public class KokoEatingBananas {
    public static int solution(int[] piles, int target) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt(); // Get max banana / pile as min result possible
        int result = right;

        while (left <= right) {
            int mid = left + (right-left) / 2;
            int eatingRate = mid;
            int totalHours = getEatingHours(piles, mid);

            if (totalHours <= target) {
                eatingRate = mid;
                right = mid - 1;
                result = Math.min(result, eatingRate);
            }
            else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static int getEatingHours(int[] piles, int eatingRate) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (int) Math.ceil((double) pile / eatingRate);
        }

        return totalHours;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,4,3,2};
        int hours = 9;
        int result = solution(input, hours);
        int expected = 2;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}