package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Test
    void findByDescription() {
        System.out.println(bookRepository.findByDescription("张嘉佳"));
    }

    @Test
    void findByDescriptionOrBookName() {
        System.out.println(bookRepository.findByDescriptionOrBookName("张嘉佳","喀秋莎之歌"));
    }

    @Test
    void findByBookNameLike() {
        System.out.println(bookRepository.findByBookNameLike("世界"));
    }

    @Test
    void findDistinctByIdLessThan() {
        System.out.println(bookRepository.findDistinctByIdLessThan(7));
    }

    @Test
    void findByBookName() {
        System.out.println(bookRepository.findByBookName("从你的全世界路过", Pageable.unpaged()));
    }

    @Test
    public void testSave() {
        Book book=Book.builder().bookName("云边有个小卖部").description("张嘉佳").price(48.0).build();
        Book book1=Book.builder().bookName("从你的全世界路过").description("张嘉佳").price(86.0).build();
        // 保存单个对象
        bookRepository.save(book);
        bookRepository.save(book1);

        List<Book> books = new ArrayList<>(Arrays.asList(
                Book.builder().bookName("喀秋莎之歌").description("麦加种族战争").price(45.0).build(),
       Book.builder().bookName("小时代").description("郭敬明").price(46.9).build(),
       Book.builder().bookName("青春").description("青春年至").price(88.5).build(),
       Book.builder().bookName("三生三世十里桃花").description("白浅上神爱情故事").price(165.0).build()));
        // 保存多个
        bookRepository.saveAll(books);
    }
    @Test
    public void testDelete() {
        Book book = Book.builder().id(7)
                .bookName("测试").description("测试").price(25.0).build();

        // 删除单条记录
        // 根据主键删除
        bookRepository.deleteById(7);
//        bookRepository.delete(book);
    }
//    @Autowired
//    private BookService bookService;

    @Test
    public void testUpdate() {
        // 根据主键更新
        Book book = Book.builder().id(8)
                .bookName("软件1851").description("沉迷学习").price(25.0).build();
        bookRepository.saveAndFlush(book);

        // 批量更新
//        List<Book> books = new ArrayList<>();
//        books.add( Book.builder().id(7)
//                .bookName("软件1851").description("沉迷学习").price(25.0).build());
//        books.add( Book.builder().id(8)
//                .bookName("移动1851").description("沉迷学习").price(25.0).build());
//        bookService.batchUpdate(books);
    }

}