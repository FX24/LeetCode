package org.example.medium;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LowestCommonAncestorinBinarySearchTree {

    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        // 1st Method (Self - Iteration)

        // Deque<TreeNode> dequeP = new ArrayDeque<>();
        // Deque<TreeNode> dequeQ = new ArrayDeque<>();
        // TreeNode curr = root;
        // while (true) {
        //     dequeP.addFirst(curr);

        //     if (p.val < curr.val) curr = curr.left;
        //     else if (p.val > curr.val) curr = curr.right;
        //     else break;
        // }

        // curr = root;
        // while (true) {
        //     dequeQ.addFirst(curr);

        //     if (q.val < curr.val) curr = curr.left;
        //     else if (q.val > curr.val) curr = curr.right;
        //     else break;
        // }

        // TreeNode temp = dequeP.peekLast();
        // while (true) {
        //     TreeNode nodeP = dequeP.peekLast();
        //     TreeNode nodeQ = dequeQ.peekLast();

        //     if (nodeP == null || nodeQ == null) return temp;
        //     if (nodeP.val != nodeQ.val) return temp;
        //     else {
        //         dequeP.pollLast();
        //         dequeQ.pollLast();
        //         temp = nodeP;
        //     }
        // }

        // 2nd Method
        // Just iterate together, when its going to different direction. return curr
        TreeNode curr = root;

        while(curr != null) {
            if (p.val > curr.val && q.val > curr.val) curr = curr.right;
            else if (p.val < curr.val && q.val < curr.val) curr = curr.left;
            else return curr;
        }
        return new TreeNode();
    }

    public static void main(String[] args) {
        Integer[] input = {5,3,8,1,4,7,9,null,2};
        TreeNode treeNode = TreeNode.build(input);
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(8);
        TreeNode result = solution(treeNode, p, q);
        TreeNode expected = new TreeNode(5);

        System.out.println("Result   : " + result.val);
        System.out.println("Expected : " + expected.val);
    }
}