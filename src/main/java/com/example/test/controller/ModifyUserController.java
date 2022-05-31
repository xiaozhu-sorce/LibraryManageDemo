package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class ModifyUserController {

    @Autowired
    UserService userService;

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @GetMapping("/list")
    public String showUsers() {
        List<UserBean> userList = userService.queryAllUser();
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("data", userList);

        return result.toJSONString();
    }

    /**
     * 新增用户
     * remark：这里未做用户名是否重复校验
     *
     * @param userBean
     * @return
     */
    @PostMapping("/add")
    public Map addUser(@RequestBody UserBean userBean) {
        int flag = userService.addUser(userBean);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == 1) {
            map.put("code", "200");
            map.put("msg", "新增用户成功");
        } else {
            map.put("msg", "新增用户失败");
        }
        return map;
    }


    /**
     * @Description: 根据用户ID删除用户信息
     * @Param: [java.lang.String, org.springframework.ui.ModelMap]
     * @return: java.lang.String
     */
    @DeleteMapping("/delete/{id}")
    public Map dropUser(@PathVariable("id") String id) {
        int flag = userService.dropUser(id);
        Map<String, Object> map = new HashMap<>();
        if (flag == 1) {
            map.put("code", "ok");
            map.put("msg", "删除用户成功");
        } else {
            map.put("msg", "删除用户失败");
        }
        return map;
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/search/{id}")
    public String queryUser(@PathVariable("id") String id) {
        JSONObject result = new JSONObject();
        UserBean userBean = userService.queryUserById(id);
        if (userBean == null) {
            result.put("msg", "未查询到相关信息");
        }else{
            result.put("msg", "ok");
            result.put("data", userBean);
        }
        return result.toJSONString();

    }

    /**
     * 根据用户ID修改用户信息
     * remark：这里未做用户名是否重复校验
     *
     * @param userBean
     * @return
     */
    @PostMapping("/modify")
    public Map modifyUser(@RequestBody UserBean userBean) {
        int flag = userService.modifyUser(userBean);
        Map<String, Object> map = new HashMap<>();
        if (flag == 1) {
            map.put("msg", "修改用户信息成功");
        } else {
            map.put("msg", "修改用户信息失败");
        }
        return map;
    }
}
