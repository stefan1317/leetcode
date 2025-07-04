package org.example;

import org.example.utils.TreeNode;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTree(Arrays.asList(7, 3, 8, 2, 9));

        System.out.println(TreeNode.bfs(root));
    }
}
