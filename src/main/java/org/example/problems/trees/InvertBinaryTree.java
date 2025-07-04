package org.example.problems.trees;

import org.example.utils.TreeNode;

import java.util.Arrays;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTree(Arrays.asList(1,2,3,4,5, null, 6));
        System.out.println(TreeNode.getListFromTree(inverseBinaryTree(root)));
    }

    public static TreeNode inverseBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);

        if (root.getLeft() != null) {
            inverseBinaryTree(root.getLeft());
        }

        if (root.getRight() != null) {
            inverseBinaryTree(root.getRight());
        }

        return root;
    }
}
