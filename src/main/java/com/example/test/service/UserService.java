package com.example.test.service;

import com.example.test.bean.HistoryBean;
import com.example.test.bean.UserBean;

import java.util.List;

public interface UserService {

    //登录时信息核对
    UserBean loginIn(UserBean userBean);

    //根据ID查询用户信息
    UserBean queryUserById(String id);

    //插入新的用户
    int addUser(UserBean userBean);

    //删除用户
    int dropUser(String id);

    //修改用户
    int modifyUser(UserBean userBean);

    //查询所有用户
    List<UserBean> queryAllUser();

    int queryBookNumber(int book_id);

    int modifyBookNumber(int id, int number);


    //用户借书操作
    int borrowBook(HistoryBean historyBean);

    int returnBook(HistoryBean historyBean);

}