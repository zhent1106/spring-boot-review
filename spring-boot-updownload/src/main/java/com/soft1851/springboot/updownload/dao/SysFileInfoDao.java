package com.soft1851.springboot.updownload.dao;

import com.soft1851.springboot.updownload.model.SysFileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName SysFileInfoDao
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/19
 **/
public interface SysFileInfoDao  extends JpaRepository<SysFileInfo, Integer> {
}