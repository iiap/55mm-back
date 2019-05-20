package com.example.fivefivemm.service;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.relation.ActionWatch;
import com.example.fivefivemm.entity.user.User;
import com.example.fivefivemm.utility.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 约拍记录业务测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月20日19:52:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionWatchServiceTest {

    @Resource
    private ActionWatchService actionWatchService;

    @Test
    public void CreateActionWatchTest() {
        User user = new User();
        user.setUserId(1);

        Action action = new Action();
        action.setActionId(2);

        Result createActionWatch = actionWatchService.CreateActionWatch(new ActionWatch(user, action));
        if (createActionWatch.getStatus().equals(Result.success)) {
            System.out.println("生成约拍记录");
        } else {
            System.out.println(createActionWatch.getMessage());
        }
    }

    @Test
    public void RetrieveActionWatchTest() {
        User user = new User();
        user.setUserId(1);

        Action action = new Action();
        action.setActionId(2);

        System.out.println(actionWatchService.RetrieveActionWatch(new ActionWatch(user, action)));
    }

    @Test
    public void DeleteActionWatchTest() {
        User user = new User();
        user.setUserId(1);

        Action action = new Action();
        action.setActionId(2);

        Result createActionWatch = actionWatchService.DeleteActionWatch(new ActionWatch(user, action));
        if (createActionWatch.getStatus().equals(Result.success)) {
            System.out.println("删除约拍记录");
        } else {
            System.out.println(createActionWatch.getMessage());
        }
    }
}
