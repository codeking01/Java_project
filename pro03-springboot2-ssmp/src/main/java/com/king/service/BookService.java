package com.king.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.king.domain.Book;

import java.util.List;


// MP的 iservice 可以代替下面这写代码
public interface BookService {
    //保存数据
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    //int 会自动装箱，底层使用的是Integer.intValue()方法，然后转化为引用数据类型
    IPage<Book> getByPage(int currentPage, int pageSize);
}
