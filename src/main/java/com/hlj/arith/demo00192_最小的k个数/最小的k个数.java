package com.hlj.arith.demo00192_最小的k个数;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author zhangyujin
 * @date 2021/9/24  11:47 上午.
 * @description
 */
public class 最小的k个数 {


    @Test
    public void test() {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }

    /**
     * 1、参数校验
     * 2、寻找
     * 3、组装数据返回
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 1、参数校验
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k) {
            return list;
        }

        // 2、寻找
        int low = 0;
        int high = input.length - 1;
        findKMin(input, low, high, k);

        // 3、组装数据返回
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    /**
     * 1、如果low小于high才行，否则非法
     */
    private static void findKMin(int[] nums, int low, int high, int k) {
        // 1、如果low小于high才行，否则非法
        if (low < high) {
            int pos = partition(nums, low, high);

            // 3.1、如果已经定位到了直接返回
            if (pos == k - 1) {
                return;
                // 3.2、 pos小于k-1，则说明还没定位到，所以继续向下一个走起
            } else if (pos < k - 1) {
                findKMin(nums, pos + 1, high, k);
                // 3.3、如果  pos > k-1  说明已经超了，则要low开始到 pos - 1
            } else {
                findKMin(nums, low, pos - 1, k);
            }
        }
    }


    /**
     * 快速排序定位元素
     */
    public static int partition(int[] nums, int low, int high) {
        int po = nums[low];
        while (low < high) {
            while (low < high && po < nums[high]) {
                high--;
            }

            nums[low] = nums[high];
            while (low < high && po > nums[low]) {
                low++;
            }
            nums[high] = nums[low];
        }

        //基准值归位 这个时候 (这里i和j是相等的)
        nums[low] = po;
        return low;
    }

}
