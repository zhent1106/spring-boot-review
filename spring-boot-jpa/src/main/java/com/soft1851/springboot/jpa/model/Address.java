package com.soft1851.springboot.jpa.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName Address
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}