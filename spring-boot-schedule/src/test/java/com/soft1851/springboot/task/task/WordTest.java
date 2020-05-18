package com.soft1851.springboot.task.task;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.poi.word.Word07Writer;

import java.awt.*;

/**
 * @ClassName WordTest
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
public class WordTest {
    public static void main(String[] args) {
        Word07Writer writer = new Word07Writer();

// 添加段落（标题）
        writer.addText(new Font("方正小标宋简体", Font.PLAIN, 22), "我是第一部分", "我是第二部分");
// 添加段落（正文）
        writer.addText(new Font("宋体", Font.PLAIN, 22), "我是正文第一部分", "我是正文第二部分");
// 写出到文件
        writer.flush(FileUtil.file("D:\\code\\word_test.txt"));
// 关闭
        writer.close();
        //读取文件
        //默认UTF-8编码，可以在构造中传入第二个参数做为编码
        FileReader fileReader = new FileReader("D:\\code\\word_test.txt","GB18030");
        String result = fileReader.readString();
        System.out.println(result);
    }
}