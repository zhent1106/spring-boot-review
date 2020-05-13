package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName BookRepository
 * @Description book
 * @Author 田震
 * @Date 2020/5/13
 **/
public interface BookRepository  extends JpaRepository<Book, Integer> {

    /**
     * 解析方法名创建查询：根据摘要查询
     * @param description
     * @return
     */
    List<Book> findByDescription(String description);

    /**
     * 解析方法名创建查询:根据内容或者摘要查询
     * @param description
     * @param bookName
     * @return
     */
    List<Book> findByDescriptionOrBookName(String description, String bookName);

    /**
     * 解析方法名创建查询
     *
     * @param text：根据内容模糊查询
     * @return
     */
    List<Book> findByBookNameLike(String text);

    /**
     * 解析方法名创建查询：查询比指定maxId小的消息集合
     *
     * @param maxId
     * @return
     */
    List<Book> findDistinctByIdLessThan(int maxId);
    /**
     * 分页查询
     *
     * @param description
     * @param pageable
     * @return
     */
    @Query("SELECT m FROM Book m WHERE m.description=?1")
    Page<Book> findByBookName(String description, Pageable pageable);

}