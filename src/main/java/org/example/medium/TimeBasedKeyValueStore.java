package org.example.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    public static String[] solution(String[] commands) {
        return List.of("").toArray(new String[0]);
    }

    public static class TimeMap {

        private Map<String, TreeMap<Integer, String>> timeMap;

        public TimeMap() {
            timeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!timeMap.containsKey(key)) return "";

            TreeMap<Integer, String> timestampMap = timeMap.get(key);

            Map.Entry<Integer, String> entry = timestampMap.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }

    public static void main(String[] args) {
        System.out.println("Expected : happy, happy, sad");

        TimeMap timeMap = new TimeMap();
        timeMap.set("alice", "happy", 1);       // store the key "alice" and value "happy" along with timestamp = 1.
        System.out.print(timeMap.get("alice", 1) + ", ");  // return "happy"
        System.out.print(timeMap.get("alice", 2) + ", ");  // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
        timeMap.set("alice", "sad", 3);         // store the key "alice" and value "sad" along with timestamp = 3.
        System.out.print(timeMap.get("alice", 3) + ", ");  // return "sad"
    }
}
