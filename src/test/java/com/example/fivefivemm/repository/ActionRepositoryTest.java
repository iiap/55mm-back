package com.example.fivefivemm.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * 动态仓库测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月19日13:55:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionRepositoryTest {

    @Resource
    private ActionRepository actionRepository;

    @Test
    public void findByActionIdTest() {
        System.out.println(actionRepository.findByActionId(2));
    }

    @Test
    @Transactional
    public void deleteByActionIdTest() {
        actionRepository.deleteByActionId(2);
    }
}
