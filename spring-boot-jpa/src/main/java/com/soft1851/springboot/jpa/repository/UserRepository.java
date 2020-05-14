package com.soft1851.springboot.jpa.repository;


import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 田震
 * @version 1.0
 * @ClassName UserRepository
 * @Description TODO
 * @date 2020-05-13 15:29
 **/
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 按userName和password相等查询唯一记录
     *
     * @param userName
     * @param password
     * @return
     */
    User findByUserNameEqualsAndPasswordEquals(String userName, String password);

    /**
     * 按nickName模糊查询一组记录
     *
     * @param nickName
     * @return
     */
    List<User> findUsersByNickNameLike(String nickName);

    /**
     * 查询年龄大于指定age的所有用户
     *
     * @param age
     * @return
     */
    List<User> findUsersByAgeGreaterThan(int age);

    /**
     * 自定义JPQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
     *
     * @param id
     * @return
     */
    @Query("select u from User u where u.id = ?1")
    User findById(long id);


    /**
     * 按id修改nickName
     *
     * @param nickName
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update test.user set nick_name = ?1 where id=?2", nativeQuery = true)
    int updateNickName(String nickName, long id);

    /**
     * 插入
     *
     * @param userName
     * @param password
     * @param email
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into test.user(user_name,password,email) value (:userName, :password, :email)", nativeQuery = true)
    int insertUser(@Param("userName") String userName, @Param("password") String password, @Param("email") String email);

    /**
     * 自定义分页查询
     *
     * @param pageable
     * @return
     */
    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    /**
     * 自定义根据nickname分页查询
     *
     * @param nickName
     * @param pageable
     * @return
     */
    @Query(value = "select * from user u where u.nick_name = ?1", nativeQuery = true)
    Page<User> findByNickName(String nickName, Pageable pageable);

//    /**
//     * 自定义根据nickname分页查询带参数Param
//     * @param nickName
//     * @param pageable
//     * @return
//     */
//    @Query("select u from User u where u.nickName = :nickName")
//    Page<User> findByNickName(@Param("nickName") String nickName, Pageable pageable);

    @Transactional(timeout = 10, rollbackFor = RuntimeException.class)
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String userName, Long id);

    /**
     * slice分页查询
     * @param nickName
     * @param email
     * @param pageable
     * @return
     */
    Slice<User> findByNickNameAndEmail(String nickName, String email, Pageable pageable);




}
