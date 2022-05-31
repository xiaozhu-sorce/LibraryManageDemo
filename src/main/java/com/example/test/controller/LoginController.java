package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @PostMapping(value = "/loginIn")
    public String login(String name, String password) {
        UserBean userBean = userService.loginIn(name, password);
        if (userBean != null) {
            return "成功";
        } else {
            return "错误";
        }
    }
}
