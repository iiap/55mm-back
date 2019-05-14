package com.example.fivefivemm.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 用户仓库测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月14日18:31:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void findByUserIdTest() {
        System.out.println(userRepository.findByUserId(1));
    }

    @Test
    public void findByAccountTest() {
        System.out.println(userRepository.findByAccount("123456789"));
    }

    @Test
    public void findByEmailTest() {
        System.out.println(userRepository.findByEmail("123456789@qq.com"));
    }
}
