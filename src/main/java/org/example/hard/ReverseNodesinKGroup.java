package org.example.hard;

import org.example.model.ListNode;

import java.util.Arrays;

public class ReverseNodesinKGroup {
    public static ListNode solution(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode result = new ListNode();
        ListNode prevGroup = result;        // Pointer for result
        ListNode curr = head;               // Pointer for ListNodes (head)

        while (isNextGroupHasGreaterOrEqualNodes(curr, k)) {
            // We save prev and tail
            ListNode prev = null;
            ListNode tail = curr;

            // Revert
            for (int i=0; i<k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect prevGroup with its new head
            prevGroup.next = prev;

            // Move prevGroup into tail
            prevGroup = tail;
        }

        // Connect remaining nodes with prevGroupt
        if (curr != null) prevGroup.next = curr;

        return result.next;
    }

    public static boolean isNextGroupHasGreaterOrEqualNodes(ListNode node, int k) {
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;

            if (counter >= k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        int k = 3;
        int[] result = solution(ListNode.fromArray(input), k).toArray();
        int[] expected = new int[]{3,2,1,4,5};

        System.out.println("Result : " + Arrays.toString(result));
        System.out.println("Expected : " + Arrays.toString(expected));
    }
}