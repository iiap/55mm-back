package com.example.fivefivemm.controller;

import com.example.fivefivemm.controller.relation.ActionCollectionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 动态收藏控制器测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月27日11:55:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionCollectionControllerTest {

    @Resource
    private ActionCollectionController actionCollectionController;

    @Test
    public void CreateActionCollectionTest() {
        System.out.println(actionCollectionController.CreateActionCollection(2, 1));
    }

    @Test
    public void DeleteActionCollection() {
        System.out.println(actionCollectionController.DeleteActionCollection(2, 1));
    }
}
