package com.example.fivefivemm.service;

import com.example.fivefivemm.entity.user.User;
import com.example.fivefivemm.utility.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void registerTest() {
        Result registerResult = userService.register(new User("2020118012", "12345678", "2020118011@qq.com"));
        if (registerResult.getStatus().equals(Result.success)) {
            System.out.println("注册成功");
        } else {
            System.out.println(registerResult.getMessage());
        }
    }

    @Test
    public void loginTest() {
        Result loginResult = userService.login(new User("1045462757", "12345678"));
        if (loginResult.getStatus().equals(Result.success)) {
            System.out.println("登录成功");
        } else {
            System.out.println(loginResult.getMessage());
        }
    }

    @Test
    public void retrieveInformation() {
        Result retrieveInformationResult = userService.retrieveInformation(null);
        if (retrieveInformationResult.getStatus().equals(Result.success)) {
            System.out.println(retrieveInformationResult.getData());
        } else {
            System.out.println(retrieveInformationResult.getMessage());
        }
    }

    @Test
    public void updateInformation() {
        User user = new User();
        user.setUserId(1);
        user.setEmail("13245@qq.com");
        user.setSex("男");
        Result updateInformationResult = userService.updateInformation(user);
        if (updateInformationResult.getStatus().equals(Result.success)) {
            System.out.println("修改成功");
        } else {
            System.out.println(updateInformationResult.getMessage());
        }

    }

    @Test
    public void updatePassword() {
        Result updatePasswordResult = userService.updatePassword(1, "123456789", "1234567");
        if (updatePasswordResult.getStatus().equals(Result.success)) {
            System.out.println("修改密码成功");
        } else {
            System.out.println(updatePasswordResult.getMessage());
        }
    }

    @Test
    public void updateAvatar() {
        User user = new User();
        user.setUserId(1);
        user.setAvatar("头像地址3");
        Result updateAvatarResult = userService.updateAvatar(user);
        if (updateAvatarResult.getStatus().equals(Result.success)) {
            System.out.println(updateAvatarResult.getData());
        } else {
            System.out.println(updateAvatarResult.getMessage());
        }
    }
}
