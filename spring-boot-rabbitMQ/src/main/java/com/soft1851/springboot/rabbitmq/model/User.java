package com.soft1851.springboot.rabbitmq.model;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
public class User implements Serializable {
    private String name;

    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}