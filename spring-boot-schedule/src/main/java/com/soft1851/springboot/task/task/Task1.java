package com.soft1851.springboot.task.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @ClassName Task1
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
//@Component
public class Task1 {
    private  int count=0;

    /**
     * 设置process（）每隔5秒执行一次，并统计执行的次数
     * cron知识点
     * cron 一共有七位，最后一位是年，Spring Boot 定时方案中只需要设置六位即可：
     *
     * 第一位，表示秒，取值 0 ~ 59；
     * 第二位，表示分，取值 0 ~ 59；
     * 第三位，表示小时，取值 0 ~ 23；
     * 第四位，日期天/日，取值 1 ~ 31；
     * 第五位，日期月份，取值 1~12；
     * 第六位，星期，取值 1 ~ 7，星期一，星期二…，注，不是第 1 周、第 2 周的意思，另外，1 表示星期天，2 表示星期一；
     * 第七位，年份，可以留空，取值 1970 ~ 2099。
     * 0 0 3 * * ? ：每天 3 点执行；
     * 0 5 3 * * ?：每天 3 点 5 分执行；
     * 0 5 3 ? * *：每天 3 点 5 分执行，与上面作用相同；
     * 0 5/10 3 * * ?：每天 3 点的 5 分、15 分、25 分、35 分、45 分、55 分这几个时间点执行；
     * 0 10 3 ? * 1：每周星期天，3 点 10 分执行，注，1 表示星期天；
     * 0 10 3 ? * 1#3：每个月的第三个星期，星期天执行，# 号只能出现在星期的位置。
     */
    @Scheduled(cron = "*/5 * * * * ?")
    private void  process(){
        System.out.println("this is scheduler task running "+(count++));
    }
}