package com.hlj.arith.a_排序算法;

import org.junit.Test;

import java.util.Arrays;

/**
作者：HealerJean
题目：
 快速排序 从两端向中间靠拢
 1．先从数列中取出一个数作为基准数。
 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 3．再对左右区间重复第二步，直到各区间只有一个数。
解题思路：
*/
public class 排序算法之_4_快速排序 {

    @Test
    public void test() {
        int nums[] = {49, 38, 65, 97, 76, 13, 27, 50};
        快速排序(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void 快速排序(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        sort(nums, low, high);
    }


    public void sort(int[] nums, int low, int high) {
        int i = low, j = high;

        //从左右两边交替扫描，直到left = right
        if (i < j) {
            //待排序的第一个元素作为基准值
            int po = nums[low];

            //每次当i比j小的时候小的时候开始比较，当它大于的时候，就会开始下一次排序
            while (i < j) {

                //从右往左扫描，找到第一个比基准值小的元素
                while (i < j && po < nums[j]) {
                    j--;
                }

                //找到这种元素将nums[j]放入nums[i]中
                nums[i] = nums[j];

                //从左往右扫描，找到第一个比基准值大的元素
                while (i < j && po > nums[i]) {
                    i++;
                }

                //找到这种元素将nums[i]放入nums[i]中
                nums[j] = nums[i];
            }

            //基准值归位 这个时候 (这里i和j是相等的)
            nums[i] = po;

            //对基准值左边的元素进行递归排序(这里i和j是相等的)
            sort(nums, low, i - 1);

            //对基准值右边的元素进行递归排序。
            sort(nums, i + 1, high);
        }
    }





}
