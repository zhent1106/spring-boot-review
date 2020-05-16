### cron的相关知识点
       
        1. cron 一共有七位，最后一位是年，Spring Boot 定时方案中只需要设置六位即可：
         
         第一位，表示秒，取值 0 ~ 59；
         第二位，表示分，取值 0 ~ 59；
         第三位，表示小时，取值 0 ~ 23；
         第四位，日期天/日，取值 1 ~ 31；
         第五位，日期月份，取值 1~12；
         第六位，星期，取值 1 ~ 7，星期一，星期二…，注，不是第 1 周、第 2 周的意思，另外，1 表示星期天，2 表示星期一；
         第七位，年份，可以留空，取值 1970 ~ 2099。
         
        2.（*）星号，可以理解为每的意思，每秒、每分、每天、每月、每年…。
          （?）问号，问号只能出现在日期和星期这两个位置，表示这个位置的值不确定，每天 3 点执行，因此第六位星期的位置，是不需要关注的，就是不确定的值；同时，日期和星期是两个相互排斥的元素，通过问号来表明不指定值，比如 1 月 10 日是星期一，如果在星期的位置另指定星期二，就前后冲突矛盾了。
          （-）减号，表达一个范围，如在小时字段中使用“10 ~ 12”，则表示从 10 到 12 点，即 10、11、12。
          （,）逗号，表达一个列表值，如在星期字段中使用“1、2、4”，则表示星期一、星期二、星期四。
          （/）斜杠，如 x/y，x 是开始值，y 是步长，比如在第一位（秒），0/15 就是从 0 秒开始，每隔 15 秒执行一次，最后就是 0、15、30、45、60，另 */y，等同于 0/y

          
        3.列举几个常用的例子：
          
          0 0 3 * * ? ：每天 3 点执行；
          0 5 3 * * ?：每天 3 点 5 分执行；
          0 5 3 ? * *：每天 3 点 5 分执行，与上面作用相同；
          0 5/10 3 * * ?：每天 3 点的 5 分、15 分、25 分、35 分、45 分、55 分这几个时间点执行；
          0 10 3 ? * 1：每周星期天，3 点 10 分执行，注，1 表示星期天；
          0 10 3 ? * 1#3：每个月的第三个星期，星期天执行，# 号只能出现在星期的位置。
          
          
          
          
### fixedRate 说明
         @Scheduled(fixedRate = 6000)：上一次开始执行时间点之后 6 秒再执行。
         @Scheduled(fixedDelay = 6000)：上一次执行完毕时间点之后 6 秒再执行。
         @Scheduled(initialDelay=1000, fixedRate=6000)：第一次延迟 1 秒后执行，之后按 fixedRate 的规则每 6 秒执行一次。
         
         

### 常见的邮件服务器扩展
         
         （SMTP、POP3）地址、端口如下：
         
         gmail(http://google.com) POP3服务器地址:http://pop.gmail.com（SSL启用 端口：995） SMTP服务器地址:http://smtp.gmail.com（SSL启用 端口：587）
         
         Foxmail: POP3服务器地址:http://pop.foxmail.com（端口：110） SMTP服务器地址:http://smtp.foxmail.com（端口：25）
         
         sina.com: POP3服务器地址:http://pop3.sina.com.cn（端口：110） SMTP服务器地址:http://smtp.sina.com.cn（端口：25）
         
         163.com: POP3服务器地址:http://pop.163.com（端口：110） SMTP服务器地址:http://smtp.163.com（端口：25）
         
         QQ邮箱 POP3服务器地址:http://pop.qq.com（端口：110） SMTP服务器地址:http://smtp.qq.com（端口：25）
         
         QQ企业邮箱 POP3服务器地址:http://pop.exmail.qq.com（端口：995） SMTP服务器地址:http://smtp.exmail.qq.com（端口：587/465）
         
         HotMail POP3服务器地址:http://pop.live.com（端口：995） SMTP服务器地址:http://smtp.live.com（端口：587）
         
         sohu.com: POP3服务器地址:http://pop3.sohu.com（端口：110） SMTP服务器地址:http://smtp.sohu.com（端口：25）       
         
### 整合Quartz
#####主要 API包括：
         Scheduler：Scheduler翻译成调度器，Quartz通过调度器来注册、暂停、删除Trigger和JobDetail。Scheduler还拥有一个SchedulerContext，顾名思义就是上下文，通过SchedulerContext我们可以获取到触发器和任务的一些信息。
         Job：Job可以定义setter(也就是set方法)来注入配置信息。也可以用同样的方法注入普通的bean。
         JobDetail：Job接口是真正需要执行的任务。JobDetail接口相当于将Job接口包装了一下，Trigger和Scheduler实际用到的都是JobDetail。
         Trigger：Trigger可以翻译成触发器，通过cron表达式或是SimpleScheduleBuilder等类，指定任务执行的周期。系统时间走到触发器指定的时间的时候，触发器就会触发任务的执行。
         JobBuilder：用于定义或创建 JobDetail 的实例。
         TriggerBuilder：用于定义或创建触发器实例。