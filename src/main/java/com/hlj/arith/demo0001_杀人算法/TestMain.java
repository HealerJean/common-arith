package com.hlj.arith.demo0001_杀人算法;

import java.util.Arrays;

/**
 * @author zhangyujin
 * @description 有一桌人（共N个人）在做一个游戏，其中一个人从1开始报数，报到第M个数的人从桌上离开，然后继续从下一个人开始从1报数，然后直到桌上的人数小于M，游戏终止请在最短的时间内实现这个过程（如果给每个人编个固定号码的话，要求输出最后剩下的人员编号），写明对应时间复杂度
 *  时间复杂度：O(nm)
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(josephSurviver(20, 7)) );
    }

    /**
     * 1、非法参数校验
     * 2、初始化环形链表
     * 3、遍历链表开始删除m节点
     * 4、收集剩余数据
     */
    public static int[] josephSurviver(int n, int m) throws IllegalArgumentException {
        // 1、非法参数校验
        if (m <= 1 || m > n) {
            return null;
        }

        //2、初始化环形链表
        //2.1、正向链表
        ListNode root = new ListNode(1);
        ListNode curNode = root;
        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(i + 1);
            curNode.next.prev = curNode;
            curNode = curNode.next;
        }
        //2.2、环形链表
        curNode.next = root;
        root.prev = curNode;



        //3、遍历链表开始删除m节点
        ListNode cur = root;
        int size = n;
        while (size >= m) {
            //3.1、获取第m个节点（cur）
            for (int i = 1; i <= m - 1; i++) {
                cur = cur.next;
            }

            //3.2、删除当前m节点
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;

            //3.3、准备开始下一次删除
            cur = cur.next;
            size--;
        }


        //4、收集剩余数据
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = cur.val;
            cur = cur.next;
        }
        return nums;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val) {
            this.val = val;
        }
    }
}