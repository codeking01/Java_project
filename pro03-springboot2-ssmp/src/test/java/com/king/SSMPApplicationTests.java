package com.king;

import com.king.dao.BookDao;
import com.king.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SSMPApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        // Book content = bookDao.getById(1);
        // System.out.println("content:" + content);
        System.out.println(bookDao.selectById(2));
        Book book = new Book();
        book.setId(4);
        book.setName("测试数据1");
        book.setType("测试类型ssssss1");
        book.setDescription("测试描述数据1aaaaa");
        //插入数据
        bookDao.insert(book);
        //根据id修改文件内容
        // bookDao.updateById(book);
    }
}
