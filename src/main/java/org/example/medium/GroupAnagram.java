package org.example.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GroupAnagram {
    public static List<List<String>> solution(String[] strs) {
        HashMap<String, List<String>> stringMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String word : strs) {
            // Take every word and sort it
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);

            String sortedWord = new String(charArray);

            // Put sorted word and raw word into Map
            if (stringMap.get(sortedWord) == null) {
                List<String> stringList = new ArrayList<>();
                stringList.add(word);
                stringMap.put(sortedWord, stringList);
            } else {
                stringMap.get(sortedWord).add(word);
            }
        }

        // Add key and value of the map to new result
        for (Map.Entry<String, List<String>> entry : stringMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("act", "pots", "tops", "cat", "stop", "hat");
        List<List<String>> output = Arrays.asList(
                Arrays.asList("hat"),
                Arrays.asList("act", "cat"),
                Arrays.asList("stop", "pots", "tops")
        );

        List<List<String>> result = solution(input.toArray(new String[0]));
        System.out.println(result);
    }
}