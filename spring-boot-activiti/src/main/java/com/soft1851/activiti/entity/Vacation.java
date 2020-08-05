package com.soft1851.activiti.entity;

import lombok.Data;
import java.util.Date;

/**
 * @ClassName Vacation
 * @Description TODO
 * @Author 田震
 * @Date 2020/8/5
 **/
@Data
public class Vacation {
    /**
     * 申请人
     */
    private String applyUser;
    private int days;
    private String reason;
    private Date applyTime;
    private String applyStatus;

    /**
     * 审核人
     */
    private String auditor;
    private String result;
    private Date auditTime;
}