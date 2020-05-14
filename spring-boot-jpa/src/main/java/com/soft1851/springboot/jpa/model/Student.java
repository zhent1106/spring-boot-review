package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "student_name", nullable = false, length = 30)
    private String studentName;

    @Column(name = "age", nullable = false, length = 30)
    private Integer age;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
//    private List<Course> courseList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "student_course",joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns=@JoinColumn(name = "course_id"))
private List<Course> courseList;
    /**
     * 级联查询
     */
//    @OneToOne(mappedBy = "student", cascade = {CascadeType.MERGE,
//            CascadeType.REFRESH}, optional = false)
//    private Clazz clazz;

}