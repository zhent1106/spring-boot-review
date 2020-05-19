package com.soft1851.springboot.updownload.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName SysFileInfo
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/19
 **/
@Data
@Entity
@Table(name = "sys_file_info")
public class SysFileInfo implements Serializable {

    @Id
    @GeneratedValue
    private Integer fileId;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Long fileSize;
}