package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName UserDetailRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/14
 **/
public interface UserDetailRepository  extends JpaSpecificationExecutor<UserDetail>, JpaRepository<UserDetail, Long> {
}