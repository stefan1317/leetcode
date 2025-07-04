package org.example.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode constructTree(List<Integer> tree) {
        if (tree.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(tree.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < tree.size()) {
            TreeNode current = queue.poll();

            if (i < tree.size() && tree.get(i) != null && current != null) {
                TreeNode left = new TreeNode(tree.get(i));
                current.left = left;
                queue.add(left);
            }
            i++;

            if (i < tree.size() && tree.get(i) != null && current != null) {
                TreeNode right = new TreeNode(tree.get(i));
                current.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    public static TreeNode addNode(int node, TreeNode root) {
        if (root == null) {
            return new TreeNode(node);
        }

        if (node < root.getVal()) {
            root.setLeft(addNode(node, root.getLeft()));
        }

        if (node > root.getVal()) {
            root.setRight(addNode(node, root.getRight()));
        }

        return root;
    }

    public static TreeNode deleteNode(int node, TreeNode root) {
        if (root.getVal() == node) {
            return null;
        }

        if (node < root.getVal()) {
            root.setLeft(deleteNode(node, root.getLeft()));
        }

        if (node > root.getVal()) {
            root.setRight(deleteNode(node, root.getRight()));
        }

        return root;
    }

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(root.getVal());
        result.addAll(preorder(root.getLeft()));
        result.addAll(preorder(root.getRight()));

        return result;
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.addAll(inorder(root.getLeft()));
        result.add(root.getVal());
        result.addAll(inorder(root.getRight()));

        return result;
    }

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.addAll(postorder(root.getLeft()));
        result.addAll(postorder(root.getRight()));
        result.add(root.getVal());

        return result;
    }

    public static List<Integer> bfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            result.add(current.getVal());

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return result;
    }

    public static List<Integer> getListFromTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode != null) {
                result.add(currentNode.getVal());

                if (currentNode.getLeft() != null || currentNode.getRight() != null) {
                    queue.add(currentNode.getLeft());
                    queue.add(currentNode.getRight());
                }
            } else {
                result.add(null);
            }
        }
        return result;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
