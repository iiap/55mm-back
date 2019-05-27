package com.example.fivefivemm.controller;

import com.example.fivefivemm.controller.relation.UserCollectionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 用户收藏控制器测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月27日11:55:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCollectionControllerTest {

    @Resource
    private UserCollectionController userCollectionController;

    @Test
    public void CreateBlogCollectionTest() {
        System.out.println(userCollectionController.CreateUserCollection(1, 2));
    }

    @Test
    public void DeleteBlogCollectionTest() {
        System.out.println(userCollectionController.DeleteUserCollection(2, 1));
    }
}
