package org.example.medium;

import java.util.Arrays;

public class Search2DMatrix {
    public static boolean solution(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // BS (Row / Vertical) -> find which row will be search furthermore
        int top = 0;
        int bottom = rows - 1;
        int mid = 0;

        while (top <= bottom) {
            mid = top + (bottom - top) / 2;

            System.out.println("mid = " + mid);
            System.out.println("top = " + top);
            System.out.println("bottom = " + bottom);

            // Case if 1 row remaining
            if (top == bottom) {
                System.out.println("CASE ROW = 1");
                break;
            }
            // Case if 2 row remaining
            if (bottom - top == 1) {
                System.out.println("CASE ROW = 2");
                if (target < matrix[bottom][0]) {
                    mid = top;
                    break;
                } else if (target > matrix[bottom][0]) {
                    mid = bottom;
                    break;
                } else return true;
            }

            if (target < matrix[mid][0]) bottom = mid;
            else if (target > matrix[mid][0]) top = mid;
            else return true;

            System.out.println("\n========================================\n");
        }

        return Arrays.binarySearch(matrix[mid], target) >= 0;



//
//        int row = mid;
//        int left = 0;
//        int right = cols - 1;
//
//        while (left <= right) {
//            mid = left + (right - left) / 2;
//
//            if (target > matrix[row][mid]) left = mid + 1;
//            else if (target < matrix[row][mid]) right = mid - 1;
//            else return true;
//        }
//
//        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1,  3,  5,  7 },
                {10, 11, 16, 20},
                {23, 30, 34, 5 }
        };
        int target = 11;
        boolean result = solution(input, target);
        boolean expected = true;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}