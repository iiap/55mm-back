package com.example.fivefivemm.repository;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
    public void CreateActionTest() {
        System.out.println(actionRepository.save(new Action(new User(1), "title", "address", 200, "content")));
    }

}
