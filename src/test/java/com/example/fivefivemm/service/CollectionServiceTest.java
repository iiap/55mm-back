package com.example.fivefivemm.service;

import com.example.fivefivemm.utility.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 收藏业务测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月27日11:54:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionServiceTest {

    @Resource
    private CollectionService collectionService;

    @Test
    public void addActionCollectionTest() {
        Result addActionCollectionResult = collectionService.addActionCollection(2, 1);
        if (addActionCollectionResult.getStatus().equals(Result.success)) {
            System.out.println("收藏成功");
        } else {
            System.out.println(addActionCollectionResult.getMessage());
        }
    }

    @Test
    public void removeActionCollectionTest() {
        Result addActionCollectionResult = collectionService.removeActionCollection(1, 1);
        if (addActionCollectionResult.getStatus().equals(Result.success)) {
            System.out.println("取消收藏成功");
        } else {
            System.out.println(addActionCollectionResult.getMessage());
        }
    }

    @Test
    public void findActionCollectionTest() {
        System.out.println(collectionService.findActionCollection(2, 1));
    }

    @Test
    public void addUserCollectionTest() {
        Result addActionCollectionResult = collectionService.addUserCollection(2, 1);
        if (addActionCollectionResult.getStatus().equals(Result.success)) {
            System.out.println("关注成功");
        } else {
            System.out.println(addActionCollectionResult.getMessage());
        }
    }

    @Test
    public void removeUserCollectionTest() {
        Result addActionCollectionResult = collectionService.removeUserCollection(2, 1);
        if (addActionCollectionResult.getStatus().equals(Result.success)) {
            System.out.println("取消关注成功");
        } else {
            System.out.println(addActionCollectionResult.getMessage());
        }
    }

    @Test
    public void findUserCollectionTest() {
        System.out.println(collectionService.findUserCollection(2, 1));
    }
}
