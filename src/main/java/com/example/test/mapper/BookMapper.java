package com.example.test.mapper;

import com.example.test.bean.BookBean;

import java.util.List;


public interface BookMapper {
    //根据图书名称查询图书
    BookBean selectBookByName(String name);

    //插入新的图书
    int insertBook(BookBean bookBean);

    //根据id删除图书
    int deleteBook(String id);

    //修改图书信息
    int updateBook(BookBean bookBean);

    //查询所有图书
    List<BookBean> getAllBook();
}
