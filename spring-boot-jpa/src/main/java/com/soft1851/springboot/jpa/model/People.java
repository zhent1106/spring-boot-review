package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName People
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "name",nullable = true,length = 32)
    private  String name;
    @Column(name = "sex",nullable = true,length = 1)
    private  String sex;
    @Column(name = "birthday",nullable = true)
    private Timestamp birthday;


//    /**
//     * people是关系维护表，当删除people，会级联删除address
//     * people中address_id字段参考address表中的id字段
//     */
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
}