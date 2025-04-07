package org.example.medium;

import org.example.model.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListwithRandomPointer {
    public static Node solution(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            oldToCopy.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = oldToCopy.get(curr);
            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);
            curr = curr.next;
        }

        return oldToCopy.get(head);
    }

    public static void main(String[] args) {
    }
}