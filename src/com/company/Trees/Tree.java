package com.company.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
   public TreeNode root;
    public Tree(){
        root = null;
    }

    // Method to insert a node with given key in a BST
    TreeNode insert(TreeNode node, int key) {
        if (node == null) {
            node = new TreeNode(key);
            return node;
        }

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);

        return node;
    }
    // Method to search for a node with given key in a BST
    boolean searchBST(TreeNode node, int key) {
        if (node == null)
            return false;

        if (key == node.data)
            return true;

        if (key < node.data)
            return searchBST(node.left, key);
        else
            return searchBST(node.right, key);
    }
    // Method to traverse the elements of a tree using BFS (level-order traversal) in iterative way
    void levelOrderOrBFSIterative() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek();
            queue.remove();
            System.out.print(temp.data + " ");

            // enqueue left child into queue
            if (temp.left != null)
                queue.add(temp.left);

            // enqueue right child into queue
            if (temp.right != null)
                queue.add(temp.right);
        }
    }
    int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }

    // Method to traverse the elements of a tree using BFS (level-order traversal) in recursive way
   public void levelOrderOrBFS() {
        int h = height(root);
        for (int i = 1; i <= h; i++)
            printNodesAtLevel(root, i, 1);
    }

    // Method to print nodes at the given level
    void printNodesAtLevel (TreeNode root, int level, int currentLevel) {
        if (root == null)
            return;
        if (level == currentLevel)
            System.out.print(root.data + " ");
        else {
            printNodesAtLevel(root.left, level, currentLevel + 1);
            printNodesAtLevel(root.right, level, currentLevel + 1);
        }
    }
  public   void preOrderDFS(TreeNode node) {
        if (node == null)
            return;

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");

        // recursively go to left subtree
        preOrderDFS(node.left);

        // recursively go to right subtree
        preOrderDFS(node.right);
    }

    // Method to print the tree in in-order traversal
   public void inOrderDFS(TreeNode node) {
        if (node == null)
            return;

        // recursively go to left subtree
        inOrderDFS(node.left);

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");

        // recursively go to right subtree
        inOrderDFS(node.right);
    }

    // Method to print the tree in post-order traversal
    void postOrderDFS(TreeNode node) {
        if (node == null)
            return;

        // recursively go to left subtree
        postOrderDFS(node.left);

        // recursively go to right subtree
        postOrderDFS(node.right);

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");
    }
}
