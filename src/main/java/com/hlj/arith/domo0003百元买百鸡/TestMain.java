package com.hlj.arith.domo0003百元买百鸡;

import org.junit.jupiter.api.Test;

/**
 * 作者 ：HealerJean
 * 题目
         公鸡5文钱一只，母鸡3文钱一只，小鸡3只一文钱，
         用100文钱买一百只鸡,其中公鸡，母鸡，小鸡都必须要有，问公鸡，母鸡，小鸡要买多少只刚好凑足100文钱。
   解题思路：
        初中数学思维 公鸡x  母鸡y 小鸡z
        5*x + 3*y + z/3 = 100
        x + y + z = 100
    那么我们首先想到就是for循环了吧

 */
public class TestMain {

    @Test
    public void start(){
        for(int x = 0; x<=100 ;x++){ //这里的100是指个数，而且不排除一只母鸡也没有
            for(int y = 0 ; y <=100-x; y++){
               int z = 100 - x -y;
               if(z%3==0){ //这个判断容易遗漏，因为我们注意是必须被3整除，如果没有这个if的时候，下面的组合可能买到死的小鸡哦，哈哈
                   if(( 5*x + 3*y + z/3 )==100){
                       System.out.println("公鸡"+x+"母鸡"+y+"小鸡"+z);
                   }
               }
            }
        }
    }

}

/**
 结果

 公鸡0母鸡25小鸡75
 公鸡4母鸡18小鸡78
 公鸡8母鸡11小鸡81
 公鸡12母鸡4小鸡84

 */