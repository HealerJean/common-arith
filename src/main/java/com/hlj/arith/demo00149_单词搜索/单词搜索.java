package com.hlj.arith.demo00149_单词搜索;

import org.junit.Test;

/**
作者：HealerJean
题目：
 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     提示：
         board 和 word 中只包含大写和小写英文字母。
         1 <= board.length <= 200
         1 <= board[i].length <= 200
         1 <= word.length <= 10^3
     示例:
         board =
         [
         ['A','B','C','E'],
         ['S','F','C','S'],
         ['A','D','E','E']
         ]
         给定 word = "ABCCED", 返回 true
         给定 word = "SEE", 返回 true
         给定 word = "ABCB", 返回 false

解题思路：
*/
public class 单词搜索 {


    @Test
    public void test(){
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        System.out.println(exist(board, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = dfs(0, i, j, board, word);
                    if (flag){
                        return true;
                    }
                }
            }
        }
        return flag;
    }


    public boolean dfs(int index, int i, int j, char[][] board, String word) {
        //终结条件
        if (index == word.length()) {
            return true;
        }

        if (i >= 0 && i < board.length
                && j >= 0 && j < board[0].length
                && board[i][j] == word.charAt(index)) {
            // 放到一个临时的位置，当搜索结束要记得放回去。这样后面的数据还可以接着遍历
            char temp = board[i][j];
            board[i][j] = '0';
            boolean flag = dfs(index + 1, i + 1, j, board, word)
                    || dfs(index + 1, i - 1, j, board, word)
                    || dfs(index + 1, i, j + 1, board, word)
                    || dfs(index + 1, i, j - 1, board, word);
            //遍历结束，放回去
            board[i][j] = temp;
            return flag;
        }
        return false;
    }
}
