package com.soft1851.springboot.rabbitmq.rabbit.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Book
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/18
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book  implements Serializable {
    private String bookName;
    private String author;
}