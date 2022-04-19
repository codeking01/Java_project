package com.king.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.king.domain.Book;

//MP 实现的通用代码
public interface IBookService extends IService<Book> {
    //@Override 如果报错了 就没有名字冲突
    boolean saveBook(Book book);

    boolean modifyBook(Book book);

    boolean deleteBookById(Integer id);

    //分页操作
    IPage<Book> getPage(int currentPage,int pageSize);
}
