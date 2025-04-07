package org.example.medium;

import org.example.model.ListNode;

import java.util.Arrays;

public class RemoveNodeFromEndofLinkedList {
    public static ListNode solution(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode curr = result;

        ListNode check = head;
        int targetIdx = getNodesLength(check, n); // get len of node O(n)

        ListNode prev = null;
        ListNode after = null;
        ListNode target = null;
        for (int i=0; i <= targetIdx+1; i++) {
            // Prev
            if (i == targetIdx-1) {
                prev = curr;
            } else if (i == targetIdx + 1) {
                after = curr;
            } else if (i == targetIdx) {
                target = curr;
            }

            if (curr != null) curr = curr.next;
        }

        // Modify pointer
        prev.next = after;

        return result.next;
    }

    public static int getNodesLength(ListNode curr, int n) {
        int counter = 0;
        while (curr != null) {
            counter++;
            curr = curr.next;
        }

        return counter-n+1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        int n = 2;
        int[] result = solution(ListNode.fromArray(input), n).toArray();
        int[] expected = new int[]{1,2,3,5};

        System.out.println("Result : " + Arrays.toString(result));
        System.out.println("Expected : " + Arrays.toString(expected));
    }
}