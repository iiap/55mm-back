package com.example.fivefivemm.repository;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 约拍记录仓库测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月20日19:52:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionWatchRepositoryTest {

    @Resource
    private ActionWatchRepository actionWatchRepository;

    @Test
    public void findByActionAndWatcherTest() {
        User user = new User();
        user.setUserId(1);

        Action action = new Action();
        action.setActionId(2);

        System.out.println(actionWatchRepository.findByActionAndWatcher(action, user));
    }
}
