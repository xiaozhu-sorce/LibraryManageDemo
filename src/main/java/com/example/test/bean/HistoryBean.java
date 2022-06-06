package com.example.test.bean;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @program: test
 * @description:
 * @author: XiaoZhu
 * @create: 2022-05-23 17:03
 **/
public class HistoryBean {
    private int id;
    private int user_id;
    private String user_name;
    private int book_id;
    private String book_name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String borrow_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String return_date;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}
