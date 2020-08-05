package com.soft1851.activiti.entity;

import lombok.Data;
import java.util.Date;


/**
 * @ClassName VacTask
 * @Description TODO
 * @Author 田震
 * @Date 2020/8/5
 **/
@Data
public class VacTask {
    private String id;
    private String name;
    private Vacation vac;
    private Date createTime;
}