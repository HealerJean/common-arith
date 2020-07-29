package com.hlj.arith.z_common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author HealerJean
 * @ClassName TestMain
 * @date 2020/4/22  9:33.
 * @Description
 */
@Slf4j
public class TestMain {

    @Test
    public void test() {
        System.out.println(waysToStep(5));
        //
        System.out.println(Integer.MAX_VALUE);
    }


    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n==3){
            return  4 ;
        }
        int pre = 1;
        int next = 2;
        int post = 4;
        int last = 0;
        for (int i = 4; i <= n; i++) {
            //max_value 最大值是 2147483647,
            //假如对三个dp[i-n]都 % 1000000007，那么也是会出现越界情况（导致溢出变为负数的问题）,因为如果本来三个dp[i-n]都接近 1000000007 那么取模后仍然不变，但三个相加则溢出
            //但是两个较大的数字相加取模则不会溢出，因为 ，如果对两个较大的dp[i-1]:dp[i-2],dp[i-3]之和% 1000000007，那么这两个较大的数相加大于 1000000007但又不溢出,取模后变成一个很小的数，与dp[i-1]相加也不溢出
            //所以取模操作也需要仔细分析,对两个较大的数之和取模再对整体取模
            last = ((pre + next) % 1000000007 + post) % 1000000007;
            pre = next;
            next = post;
            post = last;
        }
        return last;
    }
}
