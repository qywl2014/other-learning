package com.wulang.arithmetic.tree.binary;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

    @Test
    public void preOrderTest() {
        preOrder(BinaryNode.generateBinaryTree());
    }

    @Test
    public void preOrderWhileTest() {
        preOrderWhile(BinaryNode.generateBinaryTree());
    }

    @Test
    public void inOrderWhileTest() {
        inOrder(BinaryNode.generateBinaryTree());
    }

    @Test
    public void levelOrderTest() {
        preOrder(BinaryNode.generateBinaryTree());
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
     * 先根次序遍历非递归
     */
    public static void preOrderWhile(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);

        while (true) {
            if (stack.size() == 0) {
                break;
            }
            BinaryNode pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 中根次序遍历
     */
    public static void inOrder(BinaryNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    /**
     * 中根次序遍历 非递归
     */
    public static void inOrderWhile(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);

        while (true) {
            if (stack.size() == 0) {
                break;
            }

            BinaryNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 后根次序遍历
     */
    public static void postOrder(BinaryNode root) {

    }

    /**
     * 层次遍历
     */
    public static void levelOrder(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            BinaryNode head = queue.poll();
            if (head == null) {
                break;
            }
            System.out.println(head.value);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }
}
