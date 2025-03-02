package org.example.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] solution(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int number : nums) {
            numMap.put(number, numMap.getOrDefault(number, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (Map.Entry<Integer, Integer> map : numMap.entrySet()) {
            heap.offer(new int[]{map.getValue(), map.getKey()});
        }

        int[] result = new int[k];

        for (int i=k-1; i>=0; i--) {
            result[i] = heap.poll()[1];
        }
        return result;
    }
}