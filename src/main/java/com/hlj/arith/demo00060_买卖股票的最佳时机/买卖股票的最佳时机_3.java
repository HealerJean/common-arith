package com.hlj.arith.demo00060_买卖股票的最佳时机;

import org.junit.Test;

/**
作者：HealerJean
题目：买卖股票的最佳时机_3
 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:
     输入: [3,3,5,0,0,3,1,4]
     输出: 6
     解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
          随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 示例 2:
 输入: [1,2,3,4,5]
     输出: 4
     解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
          注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
          因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 示例 3:
     输入: [7,6,4,3,1]
     输出: 0
     解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
*/
public class 买卖股票的最佳时机_3 {

    @Test
    public void test(){
        // int[] prices = {3,3,5,0,0,3,1,4} ;
        int[] prices = {1,2,3,4,5} ;

        System.out.println(maxProfit(prices));
    }



    public int maxProfit(int[] prices) {
        if (prices.length == 0 ) {
            return 0;
        }

        // 初始化
        int[][] dp = new int[prices.length][5];
        // 3 状态都还没有发生，因此应该赋值为一个不可能的数
        for (int i = 0; i < prices.length; i++) {
            dp[i][3] = Integer.MIN_VALUE;
        }


        //卖出的时候，相当于是  卖出价格prices[i] - 前一天的价格，我们何不把买入价格，直接就设置为负数呢。然后负数的买入价格每次取最大的，这样得到的真实买入价格就是小的。利润会最大化
        //初始化第一个买入价格price
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {

            ///dp[i][3]，第i天，第一次买入后手里还有多少钱 = Math.max（假如入上一天前买入后手里的钱dp[i - 1][1]， 当天如果买入股票后手里的钱 -prices[i]）
            //想象空手套白狼，一开始我们手里就没钱，初始钱就是0，，
            // 现在我们是追求利益最大化，谁都想买在低点，买股票肯定是买价格低的。只有买价格低的，后面张了就能挣钱。买在高点，咋地，追涨杀跌呀
            // 买了股票之后手里就变成负数了哦 。比如，前一天价格是3 ，今天价格是5 ，那我们肯定不会买5呀，肯定会买3.买了之后，我们手里的钱就是 -3 。所以是Math.max
            dp[i][1] = Math.max(dp[i - 1][1],  - prices[i]);
            //如果觉得这行有点突兀可以写成如下 （dp[i - 1][0] 永远都是0，放心使用）
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);


            //dp[i][2]（从头到尾） 第i天，第一次卖出后手里还有多少钱 = Math.max(加入上一天卖出股票后手里的钱 dp[i - 1][2],， 上一天前<不一定非得上一天哦>第一次买入股票后手里的钱 dp[i - 1][1] + 股票当天卖出的价格 prices[i])
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);

            //dp[i][3] 第i天，（第二次买入后现在手里还有多少钱） =Math.max（加入上一天之前买入后手里的钱dp[i-1][3]， 当天买入手里的钱(第二次) =>  买入（上一天前第一次的盈利dp[i - 1][2]） +  （如果当天买入股票需要的钱 - prices[i]））
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);

            //dp[i][4]  第i天，第二次卖出后现在手里还有多少钱 = Math.max（如果上一天卖出手里的钱dp[i - 1][4]，  当天卖出后手里的钱(第二次) =》 上一天前（不一定非得上一天哦）第二次买入股票手里的钱dp[i - 1][3] + 股票当天的价格dp[i - 1][3] + prices[i]）
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        //dp[len - 1][2] 最后的结果是从头到尾至买入一次高的收入。肯定不如价格跌下来，继续买入再卖出一次的收入多。
        //但是也有可能我们就只能买一次，那就是价格不会跌下来（比如1,2,3,4,5）。 这样的结果就是dp[len - 1][2]了
        return Math.max(dp[prices.length - 1][2], dp[prices.length - 1][4]);
    }


}
