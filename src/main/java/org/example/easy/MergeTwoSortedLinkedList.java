package org.example.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLinkedList {
    public static ListNode solution(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0); // As result
        ListNode node = result; // For moving pointer

        while (list1 != null &&  list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }

            node = node.next;
        }

        // Case when 1 ot the list is emptied firstly -> next = list
        if (list1 != null) node.next = list1;
        else node.next = list2;

        // Return its head from result
        // result : 0 -> node
        // so we return its next of result
        return result.next;
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
        ListNode input1 = ListNode.fromArray(new int[]{1, 2, 4});
        ListNode input2 = ListNode.fromArray(new int[]{1, 3, 5});
        ListNode result = solution(input1, input2);
        ListNode expected = ListNode.fromArray(new int[]{1, 1, 2, 3, 4, 5});

        System.out.println("Result : " + Arrays.toString(result.toArray()));
        System.out.println("Expected : " + Arrays.toString(expected.toArray()));
    }
}