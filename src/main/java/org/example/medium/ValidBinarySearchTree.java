package org.example.medium;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ValidBinarySearchTree {

    /*
    TODO :
        - The left subtree of every node contains only nodes with keys less than the node's key.
        - The right subtree of every node contains only nodes with keys greater than the node's key.
        - Both the left and right subtrees are also binary search trees.
    * */

    public Boolean solution(TreeNode root) {
        // TOP ROOT
        if (root == null) return true;
        if (root.left != null && !(root.left.val < root.val)) return false;
        if (root.right != null && !(root.right.val > root.val)) return false;

        return validBST(root.left, Integer.MIN_VALUE, root.val) && validBST(root.right, root.val, Integer.MAX_VALUE);
    }

    public Boolean validBST(TreeNode root, int minLeft, int maxRight) {
        if (root == null) return true;

        if (root.left != null) {
            if (!(root.left.val < root.val)) return false;
            if (!(root.left.val > minLeft)) return false;
        }
        if (root.right != null) {
            if (!(root.right.val > root.val)) return false;
            if (!(root.right.val < maxRight)) return false;
        }

        minLeft = Math.max(root.val, minLeft);
        maxRight = Math.min(root.val, maxRight);
        return validBST(root.left, minLeft, maxRight) && validBST(root.right, minLeft, maxRight);
    }
}