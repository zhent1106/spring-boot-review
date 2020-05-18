package com.soft1851.springboot.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @ClassName Coder
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/17
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 255)
    private String url;

    @Column(nullable = false, length = 255)
    private String avatar;
}