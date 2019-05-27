package com.example.fivefivemm.repository;

import com.example.fivefivemm.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 用户收藏仓库测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月27日11:53:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCollectionRepositoryTest {

    @Resource
    UserCollectionRepository userCollectionRepository;

    @Test
    public void findByFocusAndFansTest() {
        System.out.println(userCollectionRepository.findByFocusAndFans(new User(1), new User(2)));
    }
}
