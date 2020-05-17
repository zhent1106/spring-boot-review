//package com.soft1851.springboot.task.jobs;
//
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//
///**
// * @ClassName HelloJob
// * @Description TODO
// * @Author 田震
// * @Date 2020/5/16
// **/
//public class HelloJob implements Job {
//    private  int count;
//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("Hello,World!");
//        count++;
//
//    }
//    public int getCount(){
//        return  count;
//    }
//}