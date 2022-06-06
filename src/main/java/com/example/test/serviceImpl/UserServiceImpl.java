package com.example.test.serviceImpl;

import com.example.test.bean.BookBean;
import com.example.test.bean.HistoryBean;
import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    UserMapper userMapper;

    /**
     * @Description:
     * @Param: userBean
     * @return:
     */
    @Override
    public UserBean loginIn(UserBean userBean) {
        return userMapper.getInfo(userBean);
    }

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public UserBean queryUserById(String id) {
        return userMapper.selectUserById(id);
    }


    /**
     * 新增用户
     *
     * @param userBean
     * @return
     */
    @Override
    public int addUser(UserBean userBean) {
        int aFlag = userMapper.insertUser(userBean);
        return aFlag;
    }

    /**
     * 根据ID删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int dropUser(String id) {
        int dFlag = userMapper.deleteUser(id);
        return dFlag;
    }


    /**
     * 修改用户信息
     * remark：实际上还是根据用户ID修改用户信息
     *
     * @param userBean
     * @return
     */
    @Override
    public int modifyUser(UserBean userBean) {
        int mFlag = userMapper.updateUser(userBean);
        return mFlag;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<UserBean> queryAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int queryBookNumber(int book_id) {
        return userMapper.getBookNumber(book_id);
    }

    @Override
    public int modifyBookNumber(int id, int number) {
        return userMapper.updateBookNumber(id, number);
    }

    /**
     * @Description: 借书
     * @Param: [com.example.test.bean.HistoryBean]
     * @return: int
     */
    @Override
    public int borrowBook(HistoryBean historyBean) {
        return userMapper.addBorrowInfo(historyBean);
    }

    /**
     * @Description: 还书
     * @Param: [com.example.test.bean.HistoryBean]
     * @return: int
     */
    @Override
    public int returnBook(HistoryBean historyBean) {
        return userMapper.addReturnInfo(historyBean);
    }
}
