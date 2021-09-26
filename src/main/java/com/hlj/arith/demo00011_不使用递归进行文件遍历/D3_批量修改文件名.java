package com.hlj.arith.demo00011_不使用递归进行文件遍历;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author zhangyujin
 * @date 2021/9/26  1:37 下午.
 * @description
 */
public class D3_批量修改文件名 {

    @Test
    public void test(){
        String nameStart = "2015-01-01";
        int lenStart = 12;
        String path = "/Users/healerjean/Desktop/HealerJean/HCode/HealerJean.github.io/_posts/13_算法/闹经急转弯";
        renameFiles(path, nameStart, lenStart);
    }


    public void renameFiles(String path, String nameStart,int lenStart) {
        File root = new File(path);
        File[] files = root.listFiles();
        Consumer<File> fileConsumer = file -> {
            System.out.println(file.getName());
            String fileOriginName = file.getName();
            fileOriginName = fileOriginName.substring(lenStart);

            String targetName = nameStart + fileOriginName;
            System.out.println(targetName);
            file.renameTo(new File(targetName));
        }; Arrays.stream(files)
                .filter(file -> file.getName().endsWith(".md"))
                .forEach(fileConsumer);
    }
}
