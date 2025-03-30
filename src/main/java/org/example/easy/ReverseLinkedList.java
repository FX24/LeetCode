package org.example.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {
    public static ListNode solution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // save next into temp ;  temp = 2
            ListNode temp = curr.next;

            // move pointer next into prev ; null <- 1
            curr.next = prev;

            // move prev into curr ; prev = 1 = curr
            prev = curr;

            // move curr into temp ; curr = 2
            curr = temp;
        }

        return prev;
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
    }

    public static void main(String[] args) {
        ListNode input = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution(input);
        ListNode expected = ListNode.fromArray(new int[]{5, 4, 3, 2, 1});

        System.out.println("Result : " + Arrays.toString(result.toArray()));
        System.out.println("Expected : " + Arrays.toString(expected.toArray()));
    }
}