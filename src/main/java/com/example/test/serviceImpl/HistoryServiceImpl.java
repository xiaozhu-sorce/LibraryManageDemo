package com.example.test.serviceImpl;

import com.example.test.bean.HistoryBean;
import com.example.test.mapper.HistoryMapper;
import com.example.test.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: test
 * @description:
 * @author: XiaoZhu
 * @create: 2022-05-23 17:29
 **/

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;

    @Override
    public int addHistory(HistoryBean historyBean) {
        return historyMapper.insertHistory(historyBean);
    }

    @Override
    public List<HistoryBean> queryAllHistoriesByUserID(String user_id) {
        return historyMapper.getAllHistoriesByUserId(user_id);
    }

    @Override
    public List<HistoryBean> queryAllHistoriesByBookName(String book_name) {
        return historyMapper.getAllHistoriesByBookName(book_name);
    }
}
