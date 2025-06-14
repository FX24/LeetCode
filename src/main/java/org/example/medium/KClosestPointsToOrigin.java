package org.example.medium;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static int[][] solution(int[][] points, int k) {
        PriorityQueue<AbstractMap.SimpleEntry<int[], Double>> minHeap = new PriorityQueue<>(
                (p1, p2) -> Double.compare(p1.getValue(), p2.getValue())
        );

        Arrays.stream(points)
                .map(p -> new AbstractMap.SimpleEntry<>(p, findRange(p)))
                .forEach(minHeap::offer);

        int[][] resultArray = new int[k][2];

        for (int i = 0; i < k; i++) {
            resultArray[i] = minHeap.poll().getKey();
        }
        return resultArray;
    }

    public static Double findRange(int[] points) {
        return Math.sqrt(
                Math.pow(points[0], 2) + Math.pow(points[1], 2)
        );
    }

    public static void main(String[] args) {
        int[][] input = {{0,2},{2,0},{2,2}};
        int k = 2;
        int[][] output = {{0,2},{2,0}};
        int[][] result = solution(input, k);

        System.out.println(Arrays.deepToString(result));
        System.out.println(Arrays.deepToString(output));
    }
}