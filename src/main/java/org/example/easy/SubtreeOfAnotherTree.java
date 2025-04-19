package org.example.easy;

import org.example.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubtreeOfAnotherTree {
    public static boolean solution(TreeNode root, TreeNode subRoot) {
        // Take the root
        if (subRoot == null) return true;
        if (root == null) return false;

        // Check if its the same tree
        if (sameTree(root, subRoot)) return true;

        // Move to node left and right
        return solution(root.left, subRoot) ||
               solution(root.right, subRoot);
    }

    public static boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }

        return false;

    }

    public static void main(String[] args) {
//        Integer[] input = {1,2,3,4,5};
//        Integer[] subTree = {2,4,5};
//        TreeNode inputNode = TreeNode.build(input);
//        TreeNode subTreeNode = TreeNode.build(subTree);
//        boolean result = solution(inputNode, subTreeNode);
//        boolean expected = true;
//
//        System.out.println("Result   : " + result);
//        System.out.println("Expected : " + expected);

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(new TreeNode(1));
        deque.addFirst(new TreeNode(2));
        deque.addFirst(new TreeNode(3));

        System.out.println(deque);

        deque.forEach(treeNode -> System.out.println(treeNode.val));


        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> result = map.entrySet().stream()
                // Optional for TreeMap but good for safety
                .map(integerListEntry -> integerListEntry.getValue())
                .collect(Collectors.toList());
                map.values().stream().collect(Collectors.toList());
    }
}