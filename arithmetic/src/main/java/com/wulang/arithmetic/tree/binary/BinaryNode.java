package com.wulang.arithmetic.tree.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryNode {
    public int value;

    public BinaryNode left;

    public BinaryNode right;

    public BinaryNode(int value, BinaryNode left, BinaryNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        BinaryNode binaryNode = generateBinaryTree();
        preOrder(binaryNode);
    }

    //
    //                         1
    //                  2              3
    //              4       5       6       7
    //           8    9          10  11
    //
    public static BinaryNode generateBinaryTree() {
        BinaryNode b8 = new BinaryNode(8, null, null);
        BinaryNode b9 = new BinaryNode(9, null, null);
        BinaryNode b4 = new BinaryNode(4, b8, b9);
        BinaryNode b5 = new BinaryNode(5, null, null);
        BinaryNode b2 = new BinaryNode(2, b4, b5);

        BinaryNode b10 = new BinaryNode(10, null, null);
        BinaryNode b11 = new BinaryNode(11, null, null);
        BinaryNode b6 = new BinaryNode(6, b10, b11);
        BinaryNode b7 = new BinaryNode(7, null, null);
        BinaryNode b3 = new BinaryNode(3, b6, b7);

        return new BinaryNode(1, b2, b3);
    }

    /**
     * 先根次序遍历
     */
    public static void preOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中根次序遍历
     */
    public static void inOrder(BinaryNode root) {

    }

    /**
     * 后根次序遍历
     */
    public static void postOrder(BinaryNode root) {

    }

    /**
     * 层次遍历
     */
    public static void levelOrder(BinaryNode root){
        Queue queue = new LinkedList();
        queue.add(root);


    }
}
