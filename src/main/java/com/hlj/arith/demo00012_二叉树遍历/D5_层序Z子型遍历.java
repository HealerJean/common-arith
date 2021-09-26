package com.hlj.arith.demo00012_二叉树遍历;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class D5_层序Z子型遍历 {

    @Test
    public void test() {
        TreeNode root = initTreeNode();
        z(root);
    }

    /**
     * 层序遍历（上到下，从从右到左）：
     * 队列的解决方案，将每一行的数据放到队列中，依次打印出来
     */
    public static void z(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        boolean left = true ;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0 ){
                size--;
                TreeNode node = queue.removeLast();
                System.out.println(node.val);
                if (left){
                    if (node.left != null){
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        queue.add(node.right);
                    }
                }else {
                    if (node.right != null){
                        queue.add(node.right);
                    }
                    if (node.left != null){
                        queue.add(node.left);
                    }
                }
            }
            left = !left;
        }
    }







    public TreeNode initTreeNode(){
        TreeNode treeNode1 = new TreeNode(3, null ,null);
        TreeNode treeNode2 = new TreeNode(6, null , null);
        TreeNode treeNode3 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode4 = new TreeNode(1, null, null);
        TreeNode root = new TreeNode(5, treeNode3, treeNode4);
        return root ;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;

        }
    }

}
