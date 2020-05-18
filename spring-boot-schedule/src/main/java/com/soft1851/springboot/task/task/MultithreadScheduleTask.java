package com.soft1851.springboot.task.task;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.word.Word07Writer;
import com.soft1851.springboot.task.model.Coder;
import com.soft1851.springboot.task.repository.CodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

/**
 * @ClassName MultithreadScheduleTask
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
//@Component //==@Repository和@service 用于比较中立的类的注解
//@EnableScheduling //开启定时任务
//@EnableAsync  //开启异步（多线程）
@Slf4j
public class MultithreadScheduleTask {
    @Resource
    private CodeRepository codeRepository;

    @Async
    @Scheduled(fixedRate = 1000)
    public void firstTask(){
        Console.log("第一个异步定时任务，{}，当前的线程：{}", DateUtil.now(),Thread.currentThread().getName());
    }
    @Async
    @Scheduled(fixedRate = 3000)
    public void secondTask(){
        Console.log("第二个异步定时任务，{}，当前的线程：{}", RandomUtil.randomInt(1,99),Thread.currentThread().getName());
    }
    @Async
    @Scheduled(fixedDelay = 2000)
    public void thirdTask(){
       int index=RandomUtil.randomInt(1,5);
       Coder coder=codeRepository.findById(index).get();
       download(coder);
       Console.log("第三个异步定时任务，获取用户，当前的线程：{}",Thread.currentThread().getName());
    }
    @Async
    public void download(Coder coder){
        String temple ="D:/code/{}.jpg";
        String path= StrUtil.format(temple, IdUtil.simpleUUID());
        HttpUtil.downloadFile(coder.getAvatar(), FileUtil.file(path));
        getQrCode(coder.getUrl(), path);
        Console.log("第四个个异步定时任务，下载用户头像，当前的线程：{}",Thread.currentThread().getName());
    }
    @Async
    public void getQrCode(String content, String logo){
        String temple ="D:/code/{}.jpg";
        int index=RandomUtil.randomInt(1,5);
//        content=codeRepository.findById(index).get().getName();
        String file= StrUtil.format(temple, IdUtil.simpleUUID());
        QrCodeUtil.generate(content, QrConfig.create().setImg(logo),FileUtil.file(file));
        Console.log("第五个异步定时任务，获取二维码，当前的线程：{}",Thread.currentThread().getName());
    }

    /**
     * 分段写出，实现word生成
     */
    @Async
    @Scheduled(fixedRate = 3000)
    public void sixthTask(){
        Word07Writer writer = new Word07Writer();

        // 添加段落（标题）
        writer.addText(new Font("方正小标宋简体", Font.PLAIN, 22), "文件读取-FileReader", "文件写入-FileWriter");
         // 添加段落（正文）
        writer.addText(new Font("宋体", Font.PLAIN, 22), "在FileUtil中本来已经针对文件的读操作做了大量的静态封装，但是根据职责分离原则，我觉得有必要针对文件读取单独封装一个类，这样项目更加清晰。当然，使用FileUtil操作文件是最方便的。", "写入文件分为追加模式和覆盖模式两类，追加模式可以用append方法，覆盖模式可以用write方法，同时也提供了一个write方法，第二个参数是可选覆盖模式。");
       // 写出到文件
        writer.flush(FileUtil.file("D:\\code\\word_test.docx"));
         // 关闭
        writer.close();
        //读取文件
        //默认UTF-8编码，可以在构造中传入第二个参数做为编码
        FileReader fileReader = new FileReader("D:\\code\\word_test.docx");
        String result = fileReader.readString();
        log.info(result);
        Console.log("第六个异步定时任务，分段写出，实现word生成，当前的线程：{}",Thread.currentThread().getName());
    }

    /**
     *生成验证码，并根据产生的随机数判断
     */
    @Async
    @Scheduled(fixedRate = 3000)
    public void seventhTask(){
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

        //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("d:\\code\\line.png");
        //输出code
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        String num= String.valueOf(RandomUtil.randomInt(9999,100000));
        lineCaptcha.verify(num);
        Console.log(num+ lineCaptcha.verify(num));
        Console.log("第七个异步定时任务，生成验证码，并根据产生的随机数判断，当前的线程：{}",Thread.currentThread().getName());
    }
    /**
     *读取excel表格
     */
    @Async
    @Scheduled(fixedDelay = 80000)
    public void eightTask(){
        ExcelReader reader = ExcelUtil.getReader("d:\\code\\test.xlsx");
        List<List<Object>> readAll = reader.read();
        Console.log("第八个异步定时任务，读取excel表格，当前的线程：{}",Thread.currentThread().getName());
    }
}