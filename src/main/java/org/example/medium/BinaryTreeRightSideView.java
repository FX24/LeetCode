package org.example.medium;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTreeRightSideView {

    public static List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    public static void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;
        if (res.size() == depth) res.add(node.val);

        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);
    }

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4};
        TreeNode treeNode = TreeNode.build(input);
        List<Integer> result = solution(treeNode);
        List<Integer> expected = List.of(
                1, 3, 4
        );

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}