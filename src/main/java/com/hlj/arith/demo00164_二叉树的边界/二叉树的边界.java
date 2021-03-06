package com.hlj.arith.demo00164_二叉树的边界;

import com.hlj.arith.z_common.treeNode.TreeNodeResources;
import lombok.val;
import org.junit.Test;

import java.util.*;

/**
作者：HealerJean
题目：
 给定一棵二叉树，以逆时针顺序从根开始返回其边界。边界按顺序包括左边界、叶子结点和右边界而不包括重复的结点。 (结点的值可能重复)
 左边界的定义是从根到最左侧结点的路径。右边界的定义是从根到最右侧结点的路径。若根没有左子树或右子树，则根自身就是左边界或右边界。注意该定义只对输入的二叉树有效，而对子树无效。
 最左侧结点的定义是：在左子树存在时总是优先访问，如果不存在左子树则访问右子树。重复以上操作，首先抵达的结点就是最左侧结点。
 最右侧结点的定义方式相同，只是将左替换成右。

     示例 1
         输入:
             1
             \
             2
             / \
             3   4
         输出:
             [1, 3, 4, 2]
         解析:
             根不存在左子树，故根自身即为左边界。
             叶子结点是3和4。
             右边界是1，2，4。注意逆时针顺序输出需要你输出时调整右边界顺序。
             以逆时针顺序无重复地排列边界，得到答案[1,3,4,2]。

     示例 2
         输入:
             ____1_____
             /          \
             2            3
             / \          /
             4   5        6
             / \      / \
             7   8    9  10
         输出:
             [1,2,4,7,8,9,10,6,3]
         解析:
             左边界是结点1,2,4。(根据定义，4是最左侧结点)
             叶子结点是结点4,7,8,9,10。
             右边界是结点1,3,6,10。(10是最右侧结点)
             以逆时针顺序无重复地排列边界，得到答案 [1,2,4,7,8,9,10,6,3]。
解题思路：
 先找左边界，再找下边界（叶子节点），最后找右边界
*/
public class 二叉树的边界 {

    @Test
    public void test(){
        System.out.println(boundaryOfBinaryTree(initTreeNode()));
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 根节点就是上边界，如果是叶子节点则当做下边界处理了
        if (!isLeaf(root)) {
            res.add(root.val);
        }


        TreeNode leftNode = root.left;
        // 如果有左子树，那么就存在左边界(不能是叶子节点，因为叶子节点我这里当做下边界了)
        while (leftNode != null) {
            // 不是叶子节点，即为左边界
            if (!isLeaf(leftNode)) {
                res.add(leftNode.val);
            }

            //继续探索，如果该左节点还有左节点则继续走
            if (leftNode.left != null) {
                leftNode = leftNode.left;
            // 当走到某一层的左边界节点没有左子节点，则拿它的右子节点继续遍历
            } else {
                leftNode = leftNode.right;
            }
        }


        // 添加下边界
        addLeaves(res, root);


        // 添加右边界，定义一个栈来最后调转顺序
        Stack<Integer> s = new Stack<>();
        TreeNode rightNode = root.right;
        while (rightNode != null) {
            if (!isLeaf(rightNode)) {
                s.push(rightNode.val);
            }
            if (rightNode.right != null) {
                rightNode = rightNode.right;
            } else {
                rightNode = rightNode.left;
            }
        }
        //从栈中取出
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }

    /**
     * 判断是叶子节点
     * @param t
     * @return
     */
    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }


    /**
     * 添加叶子节点（也就是下边界）
     * @param res
     * @param root
     */
    public void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        // 左子树的叶子节点加入 res
        if (root.left != null) {
            addLeaves(res, root.left);
        }
        // 右子树的叶子节点加入 res
        if (root.right != null) {
            addLeaves(res, root.right);
        }
    }



    public TreeNode initTreeNode(){
        // TreeNode root10 = new TreeNode(10, null, null);
        // TreeNode root9 = new TreeNode(9, null, null);
        // TreeNode root8 = new TreeNode(8, null, null);
        // TreeNode root7 = new TreeNode(7, null, null);
        // TreeNode root6 = new TreeNode(6, root9, root10);
        // TreeNode root5 = new TreeNode(5, root7, root8);
        // TreeNode root4 = new TreeNode(4, null, null);
        // TreeNode root3 = new TreeNode(3, root6, null);
        // TreeNode root2 = new TreeNode(2, root4, root5);
        // TreeNode root1 = new TreeNode(1, root2, root3);


        TreeNode root4 = new TreeNode(4, null, null);
        TreeNode root3 = new TreeNode(3, null, null);
        TreeNode root2 = new TreeNode(2, root3, root4);
        TreeNode root1 = new TreeNode(1, null, root2);
        return root1 ;
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
