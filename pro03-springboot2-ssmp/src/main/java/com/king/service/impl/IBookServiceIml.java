package com.king.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.king.dao.BookDao;
import com.king.domain.Book;
import com.king.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author codeking
 * @date 2022/4/15 11:57
 */
@Service
public class IBookServiceIml extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public boolean modifyBook(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public boolean deleteBookById(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page=new Page(currentPage, pageSize);

        bookDao.selectPage(page, null);
        return page;
    }
}
