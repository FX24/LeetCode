package org.example.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int solution(int[] nums) {
        Integer maxCount = 0;
        Integer majorityElement = 0;
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
}