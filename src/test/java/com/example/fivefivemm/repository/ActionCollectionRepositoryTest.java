package com.example.fivefivemm.repository;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 动态收藏仓库测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月27日11:52:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionCollectionRepositoryTest {

    @Resource
    private ActionCollectionRepository actionCollectionRepository;

    @Test
    public void findByCollectorAndCollectActionTest() {
        System.out.println(actionCollectionRepository.findByCollectorAndCollectAction(new User(2), new Action(1)));
    }
}
