package org.example.problems.trees;

import org.example.utils.TreeNode;

import java.util.Arrays;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTree(Arrays.asList(7, 3, 8, 2, 9));
        System.out.println(MaximumDepthOfBinaryTree.maximumDepthOfBinaryTree(root));
    }

    public static int maximumDepthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Integer.max(1 + maximumDepthOfBinaryTree(root.getLeft()),
                1 + maximumDepthOfBinaryTree(root.getRight()));
    }
}
