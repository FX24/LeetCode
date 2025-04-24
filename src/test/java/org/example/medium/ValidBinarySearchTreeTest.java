package org.example.medium;

import org.example.model.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidBinarySearchTreeTest {

    /*
    TODO :
        - The left subtree of every node contains only nodes with keys less than the node's key.
        - The right subtree of every node contains only nodes with keys greater than the node's key.
        - Both the left and right subtrees are also binary search trees.
    * */

    @Test
    @DisplayName("The left subtree of every node contains only nodes with keys less than the node's key. (VALID)")
    public void test1_1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();

        Boolean result = validBinarySearchTree.solution(root);
        assertTrue(result);
    }

    @Test
    @DisplayName("The left subtree of every node contains only nodes with keys less than the node's key. (INVALID)")
    public void test1_2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();

        Boolean result = validBinarySearchTree.solution(root);
        assertFalse(result);
    }

    // COMMIT : Add logic where left subtree of every node are lesser than its parent

    @Test
    @DisplayName("The right subtree of every node contains only nodes with keys greater than the node's key. (VALID")
    public void test2_1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();

        Boolean result = validBinarySearchTree.solution(root);
        assertTrue(result);
    }

    @Test
    @DisplayName("The right subtree of every node contains only nodes with keys greater than the node's key. (INVALID")
    public void test2_2() {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();

        Boolean result = validBinarySearchTree.solution(root);
        assertFalse(result);
    }

    // COMMIT : Add logic where right subtree of every node are greater than its parent

    @Test
    @DisplayName("Both the left and right subtrees are also binary search trees. (VALID)")
    public void test3_1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(4);

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();

        Boolean result = validBinarySearchTree.solution(root);
        assertTrue(result);
    }

    @Test
    @DisplayName("Both the left and right subtrees are also binary search trees. (INVALID)")
    public void test3_2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(11);

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();

        Boolean result = validBinarySearchTree.solution(root);
        assertFalse(result);
    }

    // COMMIT : Add logic for check where both left and right of subtress are BST
}