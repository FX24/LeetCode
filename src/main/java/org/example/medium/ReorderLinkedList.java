package org.example.medium;

import org.example.model.ListNode;

import java.util.Arrays;

public class ReorderLinkedList {
    public static ListNode solution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // Get middle nodes
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Take care of toLeft nodes (from n -> n-mid)
        ListNode toLeft = slow.next;
        ListNode prev = null;
        slow.next = null;

        // Revert
        while (toLeft != null) {
            ListNode next = toLeft.next;
            toLeft.next = prev;
            prev = toLeft;
            toLeft = next;
        }

        // Merge
        toLeft = prev;
        ListNode toRight = head;

        while (toLeft != null) {
            ListNode tempRight = toRight.next;
            ListNode tempLeft = toLeft.next;

            toRight.next = toLeft;
            toLeft.next = tempRight;

            toLeft = tempLeft;
            toRight = tempRight;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        int[] result = solution(ListNode.fromArray(input)).toArray();
        int[] expected = new int[]{1,5,2,4,3};

        System.out.println("Result : " + Arrays.toString(result));
        System.out.println("Expected : " + Arrays.toString(expected));
    }
}