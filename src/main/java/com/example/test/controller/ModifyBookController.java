package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.bean.BookBean;
import com.example.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class ModifyBookController {

    @Autowired
    BookService bookService;

    /**
     * @Description: 查询所有的图书
     * @Param: [org.springframework.ui.ModelMap]
     * @return: java.util.List<com.example.test.bean.BookBean>
     */
    @GetMapping("/list")
    public String showBooks() {
        List<BookBean> bookList = bookService.queryAllBook();
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("data", bookList);

        return result.toJSONString();
    }

    /**
     * @Description: 添加图书
     * @Param: [com.example.test.bean.BookBean]
     * @return: java.util.Map
     */
    @PostMapping("/add")
    public Map addBook(@RequestBody BookBean bookBean) {
        int flag = bookService.addBook(bookBean);
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
     * @Description: 删除图书
     * @Param: [java.lang.String]
     * @return: java.util.Map
     */
    @DeleteMapping("/delete/{id}")
    public Map dropBook(@PathVariable("id") String id) {
        int flag = bookService.dropBook(id);
        Map<String, Object> map = new HashMap<>();
        if (flag == 1) {
            map.put("msg", "删除图书成功");
            map.put("code", "ok");
        } else {
            map.put("msg", "删除图书失败");
        }
        return map;
    }

    /**
     * @Description: 根据图书名称进行图书查询
     * @Param: [java.lang.String]
     * @return: com.example.test.bean.BookBean
     */
    @PostMapping("/search")
    public String queryBook(@RequestBody Map<String, Object> params) {
        BookBean bookBean = bookService.queryBookByName((String) params.get("name"));
        JSONObject result = new JSONObject();
        if (bookBean == null) {
            result.put("mas", "未查询到相关信息");
        } else {
            result.put("msg", "ok");
            result.put("data", bookBean);
        }
        return result.toJSONString();
    }

    /**
     * @Description: 修改图书信息
     * @Param: [com.example.test.bean.BookBean]
     * @return: java.util.Map
     */
    @PostMapping("/modify")
    public Map modifyBook(@RequestBody BookBean bookBean) {
        int flag = bookService.modifyBook(bookBean);
        Map<String, Object> map = new HashMap<>();
        if (flag == 1) {
            map.put("msg", "修改图书信息成功");
        } else {
            map.put("msg", "请检查是否为合法id");
        }
        return map;
    }
}
