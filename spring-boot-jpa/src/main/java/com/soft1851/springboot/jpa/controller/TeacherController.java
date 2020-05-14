package com.soft1851.springboot.jpa.controller;

import com.soft1851.springboot.jpa.model.Teacher;
import com.soft1851.springboot.jpa.repository.TeacherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName TeacherController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
@RestController
@RequestMapping(value = "/api/teacher")
public class TeacherController {
    @Resource
    private TeacherRepository teacherRepository;

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable int id) {
        return teacherRepository.findTeacherByIdEquals(id);
    }
}