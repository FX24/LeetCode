package org.example.medium;

import org.example.model.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    int preOrderIdx = 0;
    static HashMap<Integer, Integer> midMap = new HashMap<>();

    public TreeNode solution(Integer[] preorder, Integer[] inorder) {

        // Use map to get mid_index
        for (int i = 0; i < inorder.length; i++) {
            midMap.put(inorder[i], i);
        }

        // input : preorder arr, left index, right index
        // Main point is left node
        return dfs(preorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(Integer[] preorder, int left, int right) {
        if (left > right) return null;

        // Get root value from preorder
        int rootValue = preorder[preOrderIdx];

        // Get next left and right part from inorder
        int midIndex = midMap.get(rootValue);

        TreeNode root = new TreeNode(rootValue);

        preOrderIdx++;
        // left  -> arr[left, mid-1]
        // right -> arr[mid+1, right]
        root.left = dfs(preorder, left, midIndex - 1);
        root.right = dfs(preorder, midIndex + 1, right);

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal main = new ConstructBinaryTreefromPreorderandInorderTraversal();
        Integer[] preOrder = new Integer[]{1,2,3,4};
        Integer[] inOrder = new Integer[]{2,1,3,4};
        TreeNode result = main.solution(preOrder, inOrder);
        Integer[] expected = new Integer[]{1,2,3,null,null,null,4};

        System.out.println("Result   : " + result.toArray());
        System.out.println("Expected : " + Arrays.toString(expected));
    }
}