package com.example.test.mapper;

import com.example.test.bean.HistoryBean;

import java.util.List;

/**
 * @program: test
 * @description:
 * @author: XiaoZhu
 * @create: 2022-05-23 17:08
 **/
public interface HistoryMapper {
    //增加借阅记录
    int insertHistory(HistoryBean historyBean);

    //根据用户ID查询某用户的借书记录
    List<HistoryBean> getAllHistoriesByUserId(String user_id);

    //根据图书name查询该图书的借书记录
    List<HistoryBean> getAllHistoriesByBookName(String book_name);
}
