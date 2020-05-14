package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName Clazz
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "clazz_name", nullable = false, length = 20)
    private String clazzName;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clazz_id")
    private List<Student> studentList;
}