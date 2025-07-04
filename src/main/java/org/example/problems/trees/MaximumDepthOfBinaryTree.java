package org.example.problems.trees;

import org.example.utils.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static int maximumDepthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Integer.max(1 + maximumDepthOfBinaryTree(root.getLeft()),
                1 + maximumDepthOfBinaryTree(root.getRight()));
    }
}
