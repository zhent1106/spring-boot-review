package com.soft1851.springboot.task.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CronRepositoryTest {
@Resource
 private   CronRepository cronRepository;
    @Test
    void updateCron() {
        cronRepository.updateCron("0/5 * * * * ?",1);
    }
}