package com.example.test.service;

import com.example.test.bean.BookBean;

import java.util.List;

/**
 * @program: test
 * @description:
 * @author: XiaoZhu
 * @create: 2022-05-22 23:48
 **/
public interface BookService {

    //根据图书名称查询图书
    BookBean queryBookByName(String name);

    //插入新的图书
    int addBook(BookBean bookBean);

    //根据id删除图书
    int dropBook(String id);

    //修改图书信息
    int modifyBook(BookBean bookBean);

    //查询所有图书
    List<BookBean> queryAllBook();
}
