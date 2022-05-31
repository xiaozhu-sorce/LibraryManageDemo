package com.example.test.serviceImpl;

import com.example.test.bean.BookBean;
import com.example.test.mapper.BookMapper;
import com.example.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: test
 * @description:
 * @author: XiaoZhu
 * @create: 2022-05-22 23:49
 **/
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public BookBean queryBookByName(String name) {
        return bookMapper.selectBookByName(name);
    }

    @Override
    public int addBook(BookBean bookBean ) {
        return bookMapper.insertBook(bookBean);
    }

    @Override
    public int dropBook(String id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int modifyBook(BookBean bookBean) {
        return bookMapper.updateBook(bookBean);
    }

    @Override
    public List<BookBean> queryAllBook() {
        return bookMapper.getAllBook();
    }
}
