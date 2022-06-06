package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @PostMapping(value = "/loginIn")
    public Map login(@RequestBody UserBean userB) {
        JSONObject result = new JSONObject();
        UserBean userBean = userService.loginIn(userB);
        Map<String, Object> map = new HashMap<>();
        if (userBean != null) {
            map.put("msg", "ok");
            map.put("data", userBean);
        } else {
            map.put("msg", "未查询到该用户");
        }
        return map;
    }
}
