package org.example.medium;

import org.example.model.ListNode;

import java.util.Arrays;

public class AddTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode curr = result;
        int remain = 0;

        while (l1 != null || l2 != null || remain > 0) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int sum = num1 + num2 + remain;
            remain = sum >= 10 ? 1 : 0;

            ListNode node = new ListNode(sum%10);
            curr.next = node;
            curr = curr.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1,2,3};
        int[] input2 = new int[]{4,5,6};
        int[] result = solution(ListNode.fromArray(input1), ListNode.fromArray(input2)).toArray();
        int[] expected = new int[]{5,7,9};

        System.out.println("Result   : " + Arrays.toString(result));
        System.out.println("Expected : " + Arrays.toString(expected));
    }
}