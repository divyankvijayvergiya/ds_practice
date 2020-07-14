package com.company.Trees;

public class TreeNode {
   public int data;
   public TreeNode right, left;

    public TreeNode(int value){
        data = value;
        left = right = null;
    }

}


class Source{
    public static void main(String[] args){
        Tree tree = new Tree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);

        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        tree.inOrderDFS(tree.root);
    }
}
