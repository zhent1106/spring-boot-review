package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @ClassName Book
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/13
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String bookName;

    @Column(nullable = true, length = 250)
    private String description;

    @Column(nullable = false)
    private Double price;
}