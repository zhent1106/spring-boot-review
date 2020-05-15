package com.soft1851.springboot.task.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName Cron
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/15
 **/
@Data
@Entity
public class Cron {
    @GeneratedValue
    @Id
    private  Integer cronId;
    @Column(name = "cron_name",nullable = false,length = 30)
    private  String cronName;
    @Column(name = "cron",nullable = false,length = 50)
    private  String cron;
}