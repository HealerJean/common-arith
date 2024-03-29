package com.hlj.arith.demo0002_百元买百鸡;


import org.junit.Test;

/**
 作者：HealerJean
 题目： 百元买百鸡 ：
     公鸡5文钱一只，母鸡3文钱一只，小鸡3只一文钱，用100文钱买100鸡,其中公鸡，母鸡，小鸡都必须要有，问公鸡，母鸡，小鸡要买多少只刚好凑足100文钱。
 解题思路： 公鸡x  母鸡y 小鸡z
     5 * x + 3 * y + z/3 = 100
     x + y + z = 100
     那么我们首先想到就是for循环了吧
 */
public class 百元买百鸡 {


    public void testM() {
        for (int x = 1; x <= 20; x++) {
            for (int y = 1; y < 100 - x; y++) {
                int z = 100 - x - y;
                if (z % 3 == 0) {

                }
            }
        }
    }

    @Test
    public void test() {
        //这里的20,100是指个数，而且不排除一只公鸡/母鸡也没有
        for (int x = 1; x <= 20; x++) {
            for (int y = 1; y <= 100 - x; y++) {
                int z = 100 - x - y;
                //这个判断容易遗漏，因为我们注意是必须被3整除，如果没有这个if的时候，下面的组合可能买到死的小鸡哦，哈哈
                if (z % 3 == 0) {
                    if ((5 * x + 3 * y + z / 3) == 100) {
                        System.out.println("公鸡" + x + ",母鸡" + y + ",小鸡" + z);
                    }
                }
            }
        }
    }

}

/**
 * 结果
 * 公鸡4母鸡18小鸡78
 * 公鸡8母鸡11小鸡81
 * 公鸡12母鸡4小鸡84
 */
