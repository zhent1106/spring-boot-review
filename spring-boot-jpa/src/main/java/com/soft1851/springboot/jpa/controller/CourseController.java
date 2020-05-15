package com.soft1851.springboot.jpa.controller;

import com.soft1851.springboot.jpa.model.Course;
import com.soft1851.springboot.jpa.repository.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
@RestController
@RequestMapping(value = "/api/course")
public class CourseController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping()
    public Course findCourse(@RequestParam("course") String courseName) {
        return courseRepository.findCourseByCourseName(courseName);
    }
}