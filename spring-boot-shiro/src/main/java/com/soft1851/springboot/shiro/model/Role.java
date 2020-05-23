package com.soft1851.springboot.shiro.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Role
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
@Data
public class Role  implements Serializable {
    private static final long serialVersionUID = -1767327914553823741L;

    private Integer id;

    private String role;

    private String desc;
}