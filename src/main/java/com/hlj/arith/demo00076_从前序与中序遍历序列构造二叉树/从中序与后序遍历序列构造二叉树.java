package com.hlj.arith.demo00076_从前序与中序遍历序列构造二叉树;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树 {

    @Test
    public void test(){
        int[] inorder = {9,3,15,20,7} ;
        int[] postorder = {9,15,7,20,3} ;

        System.out.println(buildTree(inorder, postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i <  inorder.length; i++){
            map.put(inorder[i], i);
        }
        return createTree(map ,inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    public TreeNode createTree(Map<Integer, Integer> map ,int[] inorder, int[] postorder, int in_left_index, int in_right_index, int post_left_index, int post_right_index) {
        if (in_left_index >= in_right_index || post_left_index >= post_right_index){
            return null ;
        }

        TreeNode root = new TreeNode(post_right_index);

        Integer  in_root_index = map.get(postorder[post_right_index]);
        int size = in_root_index - in_left_index ;

        root.left =  createTree(map ,inorder, postorder, in_left_index , in_root_index - 1, post_left_index, post_left_index + size  -1) ;

        root.right =  createTree(map ,inorder, postorder, in_root_index+1, in_right_index, post_left_index + size , post_right_index) ;
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
