package com.soft1851.springboot.jpa.repository.test1;

/**
 * @ClassName CascadeRepositoryTest
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/

import com.soft1851.springboot.jpa.model.Clazz;
import com.soft1851.springboot.jpa.model.Course;
import com.soft1851.springboot.jpa.model.Student;
import com.soft1851.springboot.jpa.model.Teacher;
import com.soft1851.springboot.jpa.repository.ClazzRepository;
import com.soft1851.springboot.jpa.repository.StudentRepository;
import com.soft1851.springboot.jpa.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 多数据源测试
 */
@SpringBootTest
@Slf4j
public class CascadeRepositoryTest {
    @Resource
    private TeacherRepository teacherRepository;
    @Resource
    private ClazzRepository clazzRepository;
    @Resource
    private StudentRepository studentRepository;

    @Test
    void testOneToOne() {
        List<Teacher> teachers = teacherRepository.findAll();
        teachers.forEach(System.out::println);
        Clazz clazz = clazzRepository.findClazzByIdEquals(1);
        System.out.println(clazz);
//        teacherRepository.deleteById(2);
    }

    @Test
    void testOneToMany() {
//        List<Student> students = studentRepository.findByClazzId(1);
//        clazz.setStudentList(students);
        Clazz clazz = clazzRepository.findClazzByIdEquals(1);
        System.out.println(clazz);
//        clazzRepository.deleteById(2);
    }

    @Test
    void testManyToMany() {
        System.out.println("**************************");
        List<Student> students = studentRepository.findByClazzId(1);
        students.forEach(student -> {
            System.out.println(student.getId() + "," + student.getStudentName() + "," + student.getAge());
            List<Course> courseList = student.getCourseList();
            courseList.forEach(course -> {
                System.out.println(course.getId() + "," + course.getCourseName());
            });
        });
    }
}