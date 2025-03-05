package org.example.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ValidSudoku {

    public static boolean solution(char[][] board) {
        /*
         * The idea is create hashset for every row, column and grid
         * */

        Map<Integer, HashSet<Character>> rowSetMap = new HashMap<>();
        Map<Integer, HashSet<Character>> colSetMap = new HashMap<>();
        Map<Integer, HashSet<Character>> gridSetMap = new HashMap<>();

        int row = 0;
        int col = 0;
        int grid = 0;
        int gridRow = 2;
        int gridCol = 2;

        for (int i = 0; i < 9; i++) {
            rowSetMap.put(i, new HashSet<>());
            colSetMap.put(i, new HashSet<>());
            gridSetMap.put(i, new HashSet<>());
        }


        while (grid<9) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> gridSet = new HashSet<>();

            // Iterate per grid (row 1-3, col 1-3) -> (row 4-6, col 1-3) -> ....
            for (int i = row; i <= gridRow; i++) {
                for (int j = col; j <= gridCol; j++) {
                    System.out.println("row = " + i + " | col = " + j);
                    char number = board[i][j];
                    if (number == '.') continue;

                    if (colSetMap.get(j).add(number) == false)return false;
                    if (rowSetMap.get(i).add(number) == false) return false;
                    if (gridSetMap.get(grid).add(number) == false) return false;

                }
            }

            grid++;

            if (gridCol < 8) {
                gridCol += 3;
                col += 3;
            } else {
                gridCol = 2;
                col = 0;

                gridRow += 3;
                row += 3;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] input = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(input[i]));
        }

        boolean output = true;
        boolean result = solution(input);

        System.out.println("output : " + output);
        System.out.println("result : " + result);

    }
}