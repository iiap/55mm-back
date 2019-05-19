package com.example.fivefivemm.controller.user;

import com.example.fivefivemm.entity.user.User;
import com.example.fivefivemm.service.UserService;
import com.example.fivefivemm.utility.Result;
import com.example.fivefivemm.utility.Utility;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月13日20:06:27
 */

//生产环境
//@CrossOrigin(origins = "http://www.hylovecode.cn")
//本地测试
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user 用户对象
     * @return failed massage
     * 101
     * 1.user对象为空
     * 2.该邮箱已被注册
     * 3.该账号已被注册
     */
    @PostMapping("/user/account")
    @ResponseBody
    public String register(@RequestBody User user) {
        Result registerResult = userService.register(user);
        if (registerResult.getStatus().equals(Result.success)) {
            return Utility.ResultBody(200, null, null);
        } else {
            return Utility.ResultBody(101, registerResult.getMessage(), null);
        }
    }

    /**
     * 用户登录
     *
     * @param user 用户对象
     * @return success data:用户Id
     * failed message
     * 102
     * *1.user对象为空
     * 2.账号不存在
     * 3.密码错误
     */
    @PostMapping("/user")
    @ResponseBody
    public String login(@RequestBody User user) {
        Result loginResult = userService.login(user);
        if (loginResult.getStatus().equals(Result.success)) {
            return Utility.ResultBody(200, null, Utility.userBody((User) loginResult.getData()));
        } else {
            return Utility.ResultBody(102, loginResult.getMessage(), null);
        }
    }

    /**
     * 获取用户信息
     *
     * @param userId 用户Id
     * @return success data:user对象
     * failed message
     * 103
     * 1.userId为空
     * 2.该用户不存在
     */
    @GetMapping("/user/information")
    @ResponseBody
    public String retrieveInformation(@RequestParam Integer userId) {
        Result retrieveInformationResult = userService.retrieveInformation(userId);
        if (retrieveInformationResult.getStatus().equals(Result.success)) {
            return Utility.ResultBody(200, null, Utility.userBody((User) retrieveInformationResult.getData()));
        } else {
            return Utility.ResultBody(103, retrieveInformationResult.getMessage(), null);
        }
    }

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return failed message
     * 104
     * 1.user对象为空
     * 2.不存在的用户
     */
    @PutMapping("/user/information")
    @ResponseBody
    public String updateInformation(@RequestBody User user) {
        Result updateInformationResult = userService.updateInformation(user);
        if (updateInformationResult.getStatus().equals(Result.success)) {
            return Utility.ResultBody(200, null, null);
        } else {
            return Utility.ResultBody(104, updateInformationResult.getMessage(), null);
        }
    }

    /**
     * 上传头像
     *
     * @param avatar 头像图片
     * @param userId 用户Id
     * @return success data:头像图片地址
     * failed message
     * 105
     * 1.user对象为空
     * 2.不存在的用户
     * 3.头像地址为空
     */
    @PostMapping("/user/avatar")
    @ResponseBody
    public String updateAvatar(@RequestParam MultipartFile avatar, @RequestParam Integer userId) {
        Result updateAvatarResult = userService.updateAvatar(new User(userId, Utility.saveImage(avatar, 1)));
        if (updateAvatarResult.getStatus().equals(Result.success)) {
            return Utility.ResultBody(200, null, updateAvatarResult.getData());
        } else {
            return Utility.ResultBody(105, updateAvatarResult.getMessage(), null);
        }
    }

    /**
     * 修改密码
     *
     * @param userId      用户Id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return failed message
     * 106
     * 1.参数不合法
     * 2.不存在的用户
     * 3.旧密码错误
     */
    @PutMapping("/user/password")
    @ResponseBody
    public String updatePassword(@RequestParam Integer userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
        Result updatePasswordResult = userService.updatePassword(userId, oldPassword, newPassword);
        if (updatePasswordResult.getStatus().equals(Result.success)) {
            return Utility.ResultBody(200, null, null);
        } else {
            return Utility.ResultBody(106, updatePasswordResult.getMessage(), null);
        }
    }
}
