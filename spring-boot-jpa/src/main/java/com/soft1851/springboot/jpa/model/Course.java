package com.soft1851.springboot.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName Course
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "course_name", nullable = false, length = 30)
    private String courseName;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> studentList;
}