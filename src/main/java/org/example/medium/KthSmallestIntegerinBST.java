package org.example.medium;

import org.example.model.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class KthSmallestIntegerinBST {
    public static int solution(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        TreeNode curr = root;
        stack.push(curr);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !set.contains(node.left.val)) {
                stack.push(node.left);
                node = node.left;
            }
            else {
                stack.pop();
                set.add(node.val);
                k--;
                if (k == 0) return node.val;

                if (node.right != null && !set.contains(node.right.val)) stack.push(node.right);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4,3,5,2,null};
        int k = 4;
        int result = solution(TreeNode.build(input), k);
        int expected = 5;

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}