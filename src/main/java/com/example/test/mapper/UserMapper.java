package com.example.test.mapper;

import com.example.test.bean.BookBean;
import com.example.test.bean.HistoryBean;
import com.example.test.bean.UserBean;

import java.util.List;

public interface UserMapper {
    //登录时信息核对
    UserBean getInfo(UserBean userBean);

    //根据ID查询用户信息
    UserBean selectUserById(String id);

    //插入新的用户
    int insertUser(UserBean userBean);

    //删除用户
    int deleteUser(String id);

    //修改用户
    int updateUser(UserBean userBean);

    //查询所有用户
    List<UserBean> getAllUser();

    //当前图书的数量
    int getBookNumber(int book_id);

    int updateBookNumber(int id,int number);

    //插入用户借书记录
    int addBorrowInfo(HistoryBean historyBean);

    //插入用户还书记录
    int addReturnInfo(HistoryBean historyBean);
}