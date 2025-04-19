package org.example.easy;

import org.example.model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBinaryTree {
    public static boolean solution(TreeNode root) {
        if (root == null) return true;
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            // Seq : add left -> add right -> process curr
            if (node.left != null && !map.containsKey(node.left)) stack.push(node.left);
            else if (node.right != null && !map.containsKey(node.right)) stack.push(node.right);
            else {
                stack.pop();
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);
                if (Math.abs(leftDepth - rightDepth) > 1) return false;
                map.put(node, 1 + Math.max(leftDepth, rightDepth));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] input = {1,2,2,3,null,null,3,4,null,null,4};
        TreeNode treeNode = TreeNode.build(input);
        boolean result = solution(treeNode);
        boolean expected = true;

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}