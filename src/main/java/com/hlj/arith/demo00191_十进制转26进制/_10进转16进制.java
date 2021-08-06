package com.hlj.arith.demo00191_十进制转26进制;

import org.junit.Test;

/**
 * @author zhangyujin
 * @date 2021/8/6  5:30 下午.
 * @description
 */
public class _10进转16进制 {

    @Test
    public void test(){
        int n = 26 ;
        System.out.println((char)(1+ 64)); //A
        System.out.println((char)(26 + 64)); //Z
        System.out.println(cover(n));
    }

    public String cover(int n){
        String str = "";
        while (n != 0) {
            int m = n % 26;
            if (m == 0) {
                m = 26;
            }
            str = (char) (m + 64) + str;
            n = (n - m) /26;
        }
        return str;
    }


}
