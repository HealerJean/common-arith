package com.hlj.arith.demo00189_字符串转数字;

import org.junit.Test;

/**
 * @author zhangyujin
 * @date 2021/7/30  11:00 上午.
 * @description
 */
public class 字符串转数字 {


    @Test
    public void test() {
        String str = "1234";
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int t = c - 48; //关键所在
            int b = 1;
            int j = str.length() - i;
            while (j > 1) {
                b *= 10;
                j--;
            }
            res = t * b + res;
        }
        System.out.println(res);
    }
}
