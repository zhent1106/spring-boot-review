package com.soft1851.springboot.task.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName Cron
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/15
 **/
@Data
@Entity
public class Cron {
    @GeneratedValue
    @Id
    private  Integer cronId;
    @Column(name = "cron_name",nullable = false,length = 30)
    private  String cronName;
    @Column(name = "cron",nullable = false,length = 50)
    private  String cron;
}


//lombok
//@Getter/@Setter：生成实体类的 getter 和 setter 方法。
//@ToString：生成实体类的 toString 方法。
//@EqualsAndHashCode：生成实体类的 hashCode 和 equals 方法。
//@NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor：为实体类生成指定类型的构造方法，分别是无参构造方法、指定部分参数的构造方法和带有所有参数的构造方法。
//@Data：@ToString、@EqualsAndHashCode、@Getter、@Setter 和 @RequiredArgsConstructor 叠加的效果。
//@Builder：按照 Builder 模式生成实体类的相关 Builder 类和方法。
//@Cleanup：实现自动资源管理功能，例如自动关闭 InputStream 等。