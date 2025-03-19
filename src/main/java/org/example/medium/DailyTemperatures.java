package org.example.medium;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] solution(int[] temperatures) {

        // Save index and its value
        Stack<AbstractMap.SimpleEntry<Integer, Integer>> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++) {
            int currTemperature = temperatures[i];
            int currIndex = i;

            // Insert to monotonic stack (curr > top)
            // 1. empty, just push
            // 2. present, compare with top (with while)
            // 2.1  if (curr > top) pop; result[pop.getKey] = currIndex - pop.getKey
            while (!stack.isEmpty() && currTemperature > stack.peek().getValue()) {
                AbstractMap.SimpleEntry<Integer, Integer> topStack = stack.pop();
                result[topStack.getKey()] = currIndex - topStack.getKey();
            }

            // 2.2  if (curr <= top) push;
            stack.push(new AbstractMap.SimpleEntry<>(currIndex, currTemperature));

            //  x ,  ,  ,v ,  ,  ,
            // [30,38,30,36,35,40,28]
            //
            // Stack    : [(1,38), (2,30), ]
            // Result   : [1, ]
            //
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{30,38,30,36,35,40,28};
        int[] result = solution(input);
        int[] expected = new int[]{1,4,1,2,1,0,0};

        System.out.println("Result : " + Arrays.toString(result));
        System.out.println("Expected : " + Arrays.toString(expected));
    }
}