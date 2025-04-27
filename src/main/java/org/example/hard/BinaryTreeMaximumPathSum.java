package org.example.hard;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeMaximumPathSum {
    // Encodes a tree to a single string.
    public int maxPathSum(TreeNode root) {
        // Get max of left and right
        int[] result = new int[]{root.val};
        dfs(root, result);
        return result[0];
    }

    public int dfs(TreeNode root, int[] result) {
        if (root == null) return 0;

        // Calculate maxLeft, maxRight
        int maxLeft = Math.max(dfs(root.left, result), 0);
        int maxRight = Math.max(dfs(root.right, result), 0);
        int currMax = root.val + maxLeft + maxRight;

        // Calculate the max
        result[0] = Math.max(result[0], currMax);

        // Take root.val + maxLeft or maxRight
        return root.val + Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum main = new BinaryTreeMaximumPathSum();
        Integer[] input = new Integer[]{-15,10,20,null,null,15,5,-5};

        int result = main.maxPathSum(TreeNode.build(input));
        int expected = 40;

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}