package com.soft1851.springboot.shiro.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/21
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6056125703075132981L;

    private Integer id;

    private String account;

    private String password;

    private String username;
}