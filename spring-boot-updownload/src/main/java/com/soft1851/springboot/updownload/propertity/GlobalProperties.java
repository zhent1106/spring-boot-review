package com.soft1851.springboot.updownload.propertity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName GlobalProperties
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/19
 **/
@Data
@Component
public class GlobalProperties {
    /** 文件存放路径 */
    @Value("${zhent.file.path}")
    private String serverPath;

    /** 文件扩展名 */
    @Value("${zhent.file.extension}")
    private String extension;
}