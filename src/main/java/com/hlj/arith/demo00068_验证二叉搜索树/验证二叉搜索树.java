package com.hlj.arith.demo00068_验证二叉搜索树;

import lombok.Data;
import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

/**
作者：HealerJean
题目：验证二叉搜索树
 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 假设一个二叉搜索树具有如下特征：
 1、节点的左子树只包含小于当前节点的数。
 2、节点的右子树只包含大于当前节点的数。
 3、所有左子树和右子树自身必须也是二叉搜索树。
     示例 1:
         输入:
         2
         / \
         1   3
         输出: true
     示例 2:
         输入:
         5
         / \
         1   4
              / \
             3   6
         输出: false
解题思路：使用中序遍历，中序遍历的规则是  左 跟 右， 左 < 跟 < 右  。
 左节点一直入栈。直到左节点取完值。然后从栈中取出来。从栈中取出的顺序其实就是 左 跟 右
 每次从栈中取一个数作为一个临时的比较值。然后和下一个栈中的数比较。该比较值大于等于 栈中当前的对象。则肯定不成功。
 一开始我们的比较对象是不存在的，所以我们需要将临时的比较值初始化，int类型
*/
public class 验证二叉搜索树 {

    @Test
    public void test(){
        System.out.println(isValidBST(initTreeNode()));
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();

        //首先我们肯定是要比较的。初次肯定不能进入
        boolean flag = false ;
        int tempVal = 0   ;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                //flag， 首次进来不比较，第二次就会比较了
                if (flag == false){
                    flag = true ;
                }else {
                    if (tempVal >= root.val ) {
                        return false;
                    }
                }
                tempVal = root.val;
                root = root.right;
            }
        }
        return true;
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
