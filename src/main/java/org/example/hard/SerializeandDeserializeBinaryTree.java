package org.example.hard;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        System.out.println("");
        System.out.println("|== Serialize ==|");

        List<String> list = new ArrayList<>();
        dfs(root, list);

        String result = String.join(",", list);
        System.out.println("Result : " + result);
        return result;
    }

    public void dfs(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            System.out.println("root = null");
            return;
        }

        System.out.println("root = " + root.val);

        list.add(String.valueOf(root.val));
        dfs(root.left, list);
        dfs(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("");
        System.out.println("|== Deserialize ==|");
        Deque<String> deque = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(deque);
    }

    public TreeNode buildTree(Deque<String> deque) {
        String rootValue = deque.pollFirst();
        System.out.print("rootValue : " + rootValue + " -> ");

        if ("null".equals(rootValue)) {
            System.out.println("return null");
            return null;
        }

        System.out.println("Create node");
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        root.left = buildTree(deque);
        root.right = buildTree(deque);

        return root;
    }

    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree main = new SerializeandDeserializeBinaryTree();
        Integer[] input = new Integer[]{1,2,3,null,null,4,5};

        String serialzeNode = main.serialize(TreeNode.build(input));
        TreeNode deserizedNode = main.deserialize(serialzeNode);

        System.out.println("Result   : " + deserizedNode.toArray());
        System.out.println("Expected : " + Arrays.toString(input));
    }
}