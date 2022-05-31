DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;

CREATE TABLE users
(
    id       int(10)      NOT NULL AUTO_INCREMENT,
    name     varchar(10)  NOT NULL,
    password varchar(100) NOT NULL,
    role     varchar(15) DEFAULT NULL COMMENT '角色权限',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 26
  DEFAULT CHARSET = utf8;

INSERT INTO users
VALUES ('1', 'admin', 'admin', 'admin');
INSERT INTO users
VALUES ('2', 'user', 'user', 'user');
INSERT INTO users
VALUES ('3', '1', '1', 'admin');
INSERT INTO users
VALUES ('4', '2', '2', 'admin');
INSERT INTO users
VALUES ('22', '3', '3', 'user');
INSERT INTO users
VALUES ('25', '4', '4', 'user');

INSERT INTO users(name, password, role)
VALUES ('xiaozhu', '12345', 'admin');


CREATE TABLE books
(
    id     int(10)     NOT NULL AUTO_INCREMENT COMMENT '图书ID',
    name   varchar(10) NOT NULL COMMENT '图书名',
    author varchar(10) NOT NULL COMMENT '作者',
    number int(20)     NOT NULL DEFAULT 0 COMMENT '图书数量',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO books (name, author, number)
VALUES ('数据库管理系统', '王珊', 10);

CREATE TABLE histories
(
    id          int(10) NOT NULL AUTO_INCREMENT COMMENT '历史id',
    user_id     int(10) COMMENT '用户id',
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    book_id     int(10) COMMENT '图书id',
    CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES books (id),
    borrow_date date COMMENT '借书时间',
    return_date date COMMENT '还书时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO histories(user_id, book_id, borrow_date, return_date)
VALUES (26, 1, '2008-11-11', '2021-11-11');

SELECT histories.id, user_id, users.name, book_id, books.name, borrow_date, return_date
FROM histories,
     books,
     users
WHERE histories.user_id = users.id
  AND book_id = books.id;

SELECT histories.id, user_id, users.name, book_id, books.name, borrow_date, return_date
FROM histories,
     books,
     users
WHERE histories.user_id = users.id
  AND book_id = books.id AND books.name = '数据库设计';

SELECT histories.id, user_id, users.name, book_id, books.name, borrow_date, return_date
FROM histories,
     books,
     users
WHERE histories.user_id = users.id
  AND book_id = books.id
  AND user_id = '26';
