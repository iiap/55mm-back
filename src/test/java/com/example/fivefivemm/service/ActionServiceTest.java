package com.example.fivefivemm.service;

import com.example.fivefivemm.entity.action.Action;
import com.example.fivefivemm.entity.user.User;
import com.example.fivefivemm.utility.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 动态业务测试类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月19日13:57:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionServiceTest {

    @Resource
    private ActionService actionService;

    @Test
    public void CreateActionTest() {
        User user = new User();
        user.setUserId(1);
        Result createActionResult = actionService.CreateAction(new Action(user, "测试约拍信息", "重庆", 150, "快来拍呀"));
        if (createActionResult.getStatus().equals(Result.success)) {
            System.out.println("发表成功");
        } else {
            System.out.println(createActionResult.getMessage());
        }
    }

    @Test
    public void RetrieveActionTest() {
        Result retrieveActionResult = actionService.RetrieveAction(3);
        if (retrieveActionResult.getStatus().equals(Result.success)) {
            System.out.println(retrieveActionResult.getData());
        } else {
            System.out.println(retrieveActionResult.getMessage());
        }
    }

    @Test
    public void UpdateActionTest() {
        User user = new User();
        user.setUserId(2);

        Action action = new Action(user, "修改测试约拍信息", "重庆南岸", 200, "快来拍呀啊啊啊啊啊啊");
        action.setActionId(2);

        Result updateActionResult = actionService.UpdateAction(action);
        if (updateActionResult.getStatus().equals(Result.success)) {
            System.out.println("修改成功");
        } else {
            System.out.println(updateActionResult.getMessage());
        }
    }

    @Test
    public void DeleteActionTest() {
        User user = new User();
        user.setUserId(1);

        Action action = new Action(user, 5);

        Result deleteActionResult = actionService.DeleteAction(action);
        if (deleteActionResult.getStatus().equals(Result.success)) {
            System.out.println("删除成功");
        } else {
            System.out.println(deleteActionResult.getMessage());
        }
    }
}
