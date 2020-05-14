package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.UserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserDetailRepositoryTest {
@Resource
private  UserDetailRepository userDetailRepository;
    @Test
    void name() {
        List<UserDetail> userList = new ArrayList<>();
        for (int i = 1; i <= 20 ;i++){
            UserDetail userDetail = UserDetail.builder()
                    .userId((long) 23)
                    .age(new Random().nextInt(50))
                    .build();
            userList.add(userDetail);
        }
        userDetailRepository.saveAll(userList);
        assertEquals(21,userDetailRepository.findAll().size());
    }

}