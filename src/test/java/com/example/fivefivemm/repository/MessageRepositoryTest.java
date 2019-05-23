package com.example.fivefivemm.repository;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 消息仓库测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月22日19:51:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageRepositoryTest {

    @Resource
    private MessageRepository messageRepository;

    @Test
    public void findByActionAndWatcherTest() {
        System.out.println(messageRepository.findByActionAndWatcher(new Action(29), new User(1)));
    }

    @Test
    public void findByWatcherTest() {
        System.out.println(messageRepository.findByWatcher(new User(2)));
    }

    @Test
    public void findByActionAuthorIdTest() {
        System.out.println(messageRepository.findByActionAuthorId(1));
    }

    @Test
    public void findByMessageIdTest() {
        System.out.println(messageRepository.findByMessageId(1));
    }
}
