package com.soft1851.springboot.task.task;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

/**
 * @ClassName lineCaptchaTest
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
public class lineCaptchaTest {
    public static void main(String[] args) {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

       //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("d:\\code\\line.png");
       //输出code
        Console.log(lineCaptcha.getCode());
       //验证图形验证码的有效性，返回boolean值
       String num= String.valueOf(RandomUtil.randomInt(9999,100000));
        lineCaptcha.verify(num);
        Console.log(num);
        Console.log( lineCaptcha.verify(num));


        ExcelReader reader = ExcelUtil.getReader("d:\\code\\test.xlsx");
        List<List<Object>> readAll = reader.read();

    }
}