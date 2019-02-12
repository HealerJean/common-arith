package com.hlj.arith.domo0008汉诺塔;

import java.util.Scanner;

/**
作者：HealerJean
题目：汉诺塔
 汉诺塔(Tower of Hanoi)源于印度传说中，大梵天创造世界时造了三根金钢石柱子，其中一根柱子自底向上叠着64片黄金圆盘。
 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
 并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。

 在进行转移操作时，都必须确保大盘在小盘下面，且每次只能移动一个圆盘，最终c柱上有所有的盘子且也是从上到下按从小到大的顺序。

解题思路：
  有两个盘子的话把1号盘先移到b柱，在把2号盘移到c柱，最后把b柱上的1号盘移到c柱就行了，
 这个时候，想象将商品的63个盘子看做一个整体，最下面的1个盘子看做一个整体，也是这样解决的。

 那么接下来这63个盘子，再看做一个整体，依次下去，是不是就成功了，这样相当于是逆推回去了 。这样的话，我们就可以使用递归算法了

 */
public class TestMain {




    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入金片数");
        int n=scanner.nextInt();

        move(n,'1','2','3');

    }

    public static  int count = 0 ;
    public static void move(int n, char start, char temp, char target){
        if(n==0){
            return;
        }
        if(n==1) { //最后一个盘子 不管怎么样都是从开始盘子，到目标盘子
            System.out.println("第"+(++count)+"次移动"+start+"----->"+target);
        }
        else{ //第一个盘子，也就是最上面的盘子进来，肯定是先到
            move(n-1,start,target,temp); //从开始盘子到临时盘子
            System.out.println("第"+(++count)+"次移动"+start+"----->"+target);
            move(n-1,temp,start,target); //临时盘子到最终的盘子
        }
    }

}
