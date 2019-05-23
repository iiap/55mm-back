package com.example.fivefivemm.service;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.message.Message;
import com.example.fivefivemm.entity.user.User;
import com.example.fivefivemm.utility.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 消息业务测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月22日19:51:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Resource
    private MessageService messageService;

    @Test
    public void CreateMessageTest() {
        Result createMessageTestResult = messageService.CreateMessage(new Message(new Action(new User(1), 1), new User(2)));
        if (createMessageTestResult.getStatus().equals(Result.success)) {
            System.out.println("保存消息成功");
        } else {
            System.out.println(createMessageTestResult.getMessage());
        }
    }

    @Test
    public void RetrieveForWatcherTest() {
        Result retrieveForWatcherResult = messageService.RetrieveForWatcher(2);
        if (retrieveForWatcherResult.getStatus().equals(Result.success)) {
            System.out.println(retrieveForWatcherResult.getData());
        } else {
            System.out.println(retrieveForWatcherResult.getMessage());
        }
    }

    @Test
    public void RetrieveForActionAuthorIdTest() {
        Result retrieveForActionAuthorResult = messageService.RetrieveForActionAuthorId(1);
        if (retrieveForActionAuthorResult.getStatus().equals(Result.success)) {
            System.out.println(retrieveForActionAuthorResult.getData());
        } else {
            System.out.println(retrieveForActionAuthorResult.getMessage());
        }
    }

    @Test
    public void UpdateIsAcceptTest() {
        Result updateIsAcceptResult = messageService.UpdateIsAccept(3, "接受");
        if (updateIsAcceptResult.getStatus().equals(Result.success)) {
            System.out.println("回复约拍成功");
        } else {
            System.out.println(updateIsAcceptResult.getMessage());
        }
    }

    @Test
    public void UpdateIsReadTest() {
        Result updateIsReadResult = messageService.UpdateIsRead(3);
        if (updateIsReadResult.getStatus().equals(Result.success)) {
            System.out.println("浏览消息成功");
        } else {
            System.out.println(updateIsReadResult.getMessage());
        }
    }

    @Test
    public void DeleteMessageTest() {
        Result deleteMessageTestResult = messageService.DeleteMessage(new Message(new Action(new User(1), 29), new User(1)));
        if (deleteMessageTestResult.getStatus().equals(Result.success)) {
            System.out.println("删除消息成功");
        } else {
            System.out.println(deleteMessageTestResult.getMessage());
        }
    }
}
