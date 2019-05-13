package com.example.fivefivemm.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void findByUserIdTest() {
        System.out.println(userRepository.findByUserId(null));
    }

    @Test
    public void findByAccountTest() {
        System.out.println(userRepository.findByAccount(null));
    }

    @Test
    public void findByEmailTest() {
        System.out.println(userRepository.findByEmail("1045462757@qq.com"));
    }
}
