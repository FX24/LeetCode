package org.example.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    // 1st Method : LinkedHashMap
//    int maxCapacity;
//
//    LinkedHashMap<Integer, Integer> cache;
//
//    public LRUCache(int capacity) {
//        this.maxCapacity = capacity;
//        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size() > maxCapacity;
//            }
//        };
//    }
//
//    public int get(int key) {
//        int value = cache.getOrDefault(key, -1);
//        System.out.println(value);
//        return value;
//    }
//
//    public void put(int key, int value) {
//        System.out.println("put {" + key + "," + value + "}");
//        cache.put(key, value);
//    }

    // 2nd Method : Double LinkedList
    private int maxCapacity;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node) {
        // 1 <-> 2 <-> 3
        Node prev = node.prev; // 1
        Node next = node.next; // 3
        prev.next = next; // 1 -> 3
        next.prev = prev; // 3 -> 1
    }

    public void insert(Node node) {
        // 1 <-> 2 <-> X
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > maxCapacity) {
            Node LRU = this.left.next;
            remove(LRU);
            cache.remove(LRU.key);
        }
    }

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 10);  // cache: {1=10}
        lRUCache.get(1);      // return 10
        lRUCache.put(2, 20);  // cache: {1=10, 2=20}
        lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
        lRUCache.get(2);      // returns 20
        lRUCache.get(1);      // return -1 (not found)
    }
}