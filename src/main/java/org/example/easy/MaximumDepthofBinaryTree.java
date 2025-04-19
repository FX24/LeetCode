package org.example.easy;

import org.example.model.TreeNode;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class MaximumDepthofBinaryTree {
    public static int solution(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(solution(root.left), solution(root.right));
//        Stack<AbstractMap.SimpleEntry<TreeNode, Integer>> stack = new Stack<>();
//        stack.push(new AbstractMap.SimpleEntry<>(root, 1));
//        int max = 0;
//
//        while (!stack.isEmpty()) {
//            Map.Entry<TreeNode, Integer> curr = stack.pop();
//            TreeNode node = curr.getKey();
//            int depth = curr.getValue();
//
//            if (node != null) {
//                max = Math.max(max, depth);
//                stack.push(new AbstractMap.SimpleEntry<>(node.left, depth + 1));
//                stack.push(new AbstractMap.SimpleEntry<>(node.right, depth + 1));
//            }
//        }
//
//        return max;
    }

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, null, null, 4};
        TreeNode treeNode = TreeNode.build(input);
        int result = solution(treeNode);
        int expected = 3;

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}