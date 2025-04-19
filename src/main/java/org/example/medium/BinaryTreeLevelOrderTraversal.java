package org.example.medium;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> solution(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        if (root == null) return new ArrayList<>();
        getLevel(root, 1, map);

        return new ArrayList<>(map.values());
    }

    public static void getLevel(TreeNode node, Integer level, TreeMap<Integer, List<Integer>> map) {
        if (node == null) return;

        if (map.get(level) == null) {
            List<Integer> list = new ArrayList<>();
            map.put(level, list);
        }

        map.get(level).add(node.val);

        getLevel(node.left, level+1, map);
        getLevel(node.right, level+1, map);
    }
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,5,6,7};
        TreeNode treeNode = TreeNode.build(input);
        List<List<Integer>> result = solution(treeNode);
        List<List<Integer>> expected = List.of(
                List.of(1),
                List.of(2,3),
                List.of(4,5,6,7)
        );

        System.out.println("Result   : " + result);
        System.out.println("Expected : " + expected);
    }
}