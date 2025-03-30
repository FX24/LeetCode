package org.example.hard;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static double solution(int[] nums1, int[] nums2) {
        // Get left and right partition of each nums
        // Check if max(leftPart) of each nums is <= opposite min(rightPart)
        // - Nums1.LeftPart <= Nums2.RightPart ; vice versa
        // If not valid -> adjust leftPartition and rightPartition till its valid
        // Final compute :
        // - if total is even (4,6,18)
        // - - we have 4 number -> L1, L2, R1, R2
        // - - median = Max(L1,L2) + Min(R1,R2)
        // - if odd (3,5,8)
        // - - median = Min{R1,R2}

        int[] A = nums1;
        int[] B = nums2;

        int total = A.length + B.length;
        int half = (total + 1) / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int L = 0;
        int R = A.length;

        while (true) {
            int midA = (L + R) / 2;
            int midB = half - midA;

            int Aleft = midA > 0 ? A[midA - 1] : Integer.MIN_VALUE;
            int Aright = midA < A.length ? A[midA] : Integer.MAX_VALUE;
            int Bleft = midB > 0 ? B[midB - 1] : Integer.MIN_VALUE;
            int Bright = midB < B.length ? B[midB] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 0) {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                } else {
                    return Math.min(Aleft, Bleft);
                }
            } else if (Aleft > Bright) {
                R = midA - 1;
            } else {
                L = midA + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3};
        double result = solution(nums1, nums2);
        double expected = 2.5;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}