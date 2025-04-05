package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

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
