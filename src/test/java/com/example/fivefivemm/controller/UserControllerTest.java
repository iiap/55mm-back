package com.example.fivefivemm.controller;

import com.example.fivefivemm.controller.user.UserController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Resource
    private UserController userController;


}
