package com.soft1851.springboot.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class T_Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "username",nullable = false)
    private String username;
}