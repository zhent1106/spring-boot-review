package com.soft1851.springboot.encrypt.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/15
 **/
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "birthday",nullable = false)
    private LocalDateTime birthday;

    @Column(name = "mail",nullable = false)
    private String mail;
}