package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.bean.HistoryBean;
import com.example.test.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: test
 * @description:
 * @author: XiaoZhu
 * @create: 2022-05-23 17:47
 **/

@RestController
@RequestMapping("/history")
public class ModifyHistoryController {

    @Autowired
    HistoryService historyService;

    /**
    * @Description: 添加借书信息
    * @Param: [com.example.test.bean.HistoryBean]
    * @return: java.util.Map
    */
    @PostMapping("/add")
    public Map addHistory(@RequestBody HistoryBean historyBean){
        int flag = historyService.addHistory(historyBean);
        Map<String, Object> map = new HashMap<>();
        if (flag == 1) {
            map.put("code", "200");
            map.put("msg", "新增图书成功");
        } else {
            map.put("msg", "新增图书失败");
        }
        return map;
    }
    
    /**
    * @Description: 根据用户id查询历史
    * @Param: [int]
    * @return: java.lang.String
    */
    @GetMapping("/listbyuserid/{id}")
    public String showHistorieByUserId(@PathVariable String id){
        List<HistoryBean> list = historyService.queryAllHistoriesByUserID(id);
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("data", list);

        return result.toJSONString();
    }
    
    /**
    * @Description: 根据图书名查询图书
    * @Param: [java.lang.String]
    * @return: java.lang.String
    */
    @GetMapping("/listbybookname/{name}")
    public String showHistoriesByBookName(@PathVariable String name){
        List<HistoryBean> list = historyService.queryAllHistoriesByBookName(name);
        System.out.println(name);
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("data", list);

        return result.toJSONString();
    }
}
