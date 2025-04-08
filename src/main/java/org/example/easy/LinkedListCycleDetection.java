package org.example.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedListCycleDetection {
    public static boolean solution(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (visited.contains(curr)) return true;
            else visited.add(curr);
            curr = curr.next;
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode fromArray(int[] values) {
            if (values == null || values.length == 0) return null;

            ListNode head = new ListNode(values[0]);
            ListNode current = head;

            for (int i = 1; i < values.length; i++) {
                current.next = new ListNode(values[i]);
                current = current.next;
            }

            return head;
        }

        public int[] toArray() {
            List<Integer> list = new ArrayList<>();
            ListNode current = this;

            while (current != null) {
                list.add(current.val);
                current = current.next;
            }

            return list.stream().mapToInt(i -> i).toArray();
        }

        public static void createCycle(ListNode head, int index) {
            if (head == null || index < 0) return;

            ListNode current = head;
            ListNode cycleNode = null;
            int pos = 0;

            // Traverse the list and find the cycle position
            while (current.next != null) {
                if (pos == index) {
                    cycleNode = current; // Save the node where cycle should form
                }
                current = current.next;
                pos++;
            }

            // Connect the last node to the cycle node
            if (cycleNode != null) {
                current.next = cycleNode;
            }
        }
    }

    public static void main(String[] args) {
        ListNode input = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        ListNode.createCycle(input, 1);
        boolean result = solution(input);
        boolean expected = true;

        System.out.println("Result : " + result);
        System.out.println("Expected : " + expected);

    }
}