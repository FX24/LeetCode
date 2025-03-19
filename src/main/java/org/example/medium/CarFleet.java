package org.example.medium;

import java.util.AbstractMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class CarFleet {
    public static int solution(int target, int[] position, int[] speed) {
        // Init
        int result = 0;
        // Insert to maxHeap
        // Ot(n logn) || Os(n)
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (p1, p2) -> p2.getKey() - p1.getKey()
        );

        for (int i=0; i<position.length; i++) {
            int currPosition = position[i];
            int currSpeed = speed[i];
            maxHeap.offer(new AbstractMap.SimpleEntry<>(currPosition, currSpeed));
        }

        // Insert monotonic stack
        // Ot(n) || Os(n)
        Stack<Integer> stack = new Stack<>();
        Double lastFleet = 0.0;
        while (!maxHeap.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> currPair = maxHeap.poll();
            Double currPosition = Double.valueOf(currPair.getKey());
            Double currSpeed = Double.valueOf(currPair.getValue());
            Double distance = (Double.valueOf(target) - currPosition) / currSpeed;

            if (distance > lastFleet) {
                lastFleet = distance;
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] position = new int[]{4,1,0,7};
        int[] speed = new int[]{2,2,1,1};
        int target = 10;
        int result = solution(target, position, speed);
        int expected = 3;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);
    }
}