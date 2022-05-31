package com.example.test.service;

import com.example.test.bean.HistoryBean;

import java.util.List;

/**
 * @program: test
 * @description:
 * @author: XiaoZhu
 * @create: 2022-05-23 17:21
 **/
public interface HistoryService {
    //增加新的记录
    int addHistory(HistoryBean historyBean);

    //根据用户ID进行查询
    List<HistoryBean> queryAllHistoriesByUserID(String user_id);

    //根据图书name进行查询
    List<HistoryBean> queryAllHistoriesByBookName(String book_name);
}
