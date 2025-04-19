package org.example.easy;

import org.example.model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DiameterOfBinaryTree {
    public static int solution(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int diameter = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !map.containsKey(node.left)) stack.push(node.left);
            else if (node.right != null && !map.containsKey(node.right)) stack.push(node.right);
            else {
                stack.pop();
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);

                map.put(node, 1 + Math.max(leftDepth, rightDepth));
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
        }

        return diameter;
    }

    public static void main(String[] args) {
        Integer[] input = {1,null,2,3,4,5};
        TreeNode treeNode = TreeNode.build(input);
        int result = solution(treeNode);
        int expected = 3;

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}