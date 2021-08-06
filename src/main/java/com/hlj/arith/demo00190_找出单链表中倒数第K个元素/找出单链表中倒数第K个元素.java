package com.hlj.arith.demo00190_找出单链表中倒数第K个元素;

import org.junit.Test;

/**
 * @author zhangyujin
 * @date 2021/8/3  10:02 上午.
 * @description
 */
public class 找出单链表中倒数第K个元素 {

    /**
     * 方法1
     */
    @Test
    public void test1() {
        int k = 2;
        ListNode head = listNode();
        System.out.println(findLastK1(head, k));
    }


    /**
     * 方法1：遍历两次
     */
    public ListNode findLastK1(ListNode head, int k) {
        ListNode listNode = head;
        int n = 0;
        while (listNode != null) {
            n++;
            listNode = listNode.next;
        }

        int i = 1;
        while (i <= n - k) {
            listNode = listNode.next;
            i++;
        }
        return listNode;
    }


    /**
     * 方法2： 利用
     */
    public ListNode findLastK2(ListNode head, int k) {
        ListNode list1 = head;
        ListNode list2 = head;
        for (int i = 0; i < k - 1 && list1 != null; i++) {
            list1 = list1.next;
        }

        while (list1 != null) {
            list1 = list1.next;
            list2 = list2.next;
        }
        return list2;
    }


    public ListNode listNode() {
        ListNode listNode_5 = new ListNode(5, null);
        ListNode listNode_4 = new ListNode(4, listNode_5);
        ListNode listNode_3 = new ListNode(2, listNode_4);
        ListNode listNode_2 = new ListNode(1, listNode_3);
        ListNode listNode_1 = new ListNode(0, listNode_2);
        return listNode_1;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

