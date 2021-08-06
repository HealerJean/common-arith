package com.hlj.arith.a_排序算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author HealerJean
 * @date 2020/12/3  16:07.
 * @description
 */
public class TestMain {

    @Test
    public void test() {
        int nums[] = {49, 38, 65, 97, 76, 13, 27, 50};
        // 冒泡(nums);
        // 选择(nums);
        直接插入排序(nums);
        // 快速排序(nums);


        System.out.println(Arrays.toString(nums));
    }


    public void 快速排序(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        sort(nums, low, high);

    }


    public void sort(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        if (i < j) {
            int mod = low;

            while (i < j) {

            }
            while (i < j && nums[mod] < nums[j]) {
                j--;
            }
            if (nums[i] < nums[j]) {
                int temp = nums[i];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }

        }

    }

    private void 直接插入排序(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[i];
            for (; j > 0; j--) {
                if (temp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                }else {
                    break;
                }
            }
            nums[j] = temp;
        }
    }



    private void 选择(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i){
                int temp = nums[minIdx];
                nums[minIdx] = nums[i];
                nums[i] = temp;
            }
        }

    }


    private void 冒泡(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (Boolean.FALSE.equals(flag)) {
                break;
            }
        }
    }


}
