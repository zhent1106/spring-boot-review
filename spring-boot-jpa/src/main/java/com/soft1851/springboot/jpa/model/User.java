package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author: 田震
 * @date: 2020/5/12
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    /**
     * 主键，策略为自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * nullable = false为非空约束，unique = true是唯一约束
     */
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 32)
    private String nickName;

    @Column
    private Integer age;

    @Column
    private LocalDateTime regTime;

//    // 1、关系维护端，负责多对多关系的绑定和解除
//    // 2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
//    // 3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Authority)
//    // 4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
//    // 即表名为user_authority
//    // 关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id
//    // 关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id
//    // 主表就是关系维护端对应的表，从表就是关系被维护端对应的表
//    @ManyToMany
//    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "authority_id"))
//    private List<Authority> authorityList;
}