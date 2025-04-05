package org.example.easy;

import org.example.model.ListNode;

import java.util.Arrays;

public class ReverseLinkedList {
    public static ListNode solution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode input = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution(input);
        ListNode expected = ListNode.fromArray(new int[]{5, 4, 3, 2, 1});

        System.out.println("Result : " + Arrays.toString(result.toArray()));
        System.out.println("Expected : " + Arrays.toString(expected.toArray()));
    }
}
