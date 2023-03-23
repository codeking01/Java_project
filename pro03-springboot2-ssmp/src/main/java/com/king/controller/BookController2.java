package com.king.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.king.controller.utils.R;
import com.king.domain.Book;
import com.king.service.BookService;
import com.king.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author codeking
 * @date 2022/4/19 10:12
 */

@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService ibookService;

    @GetMapping
    public R getAll() {
        // 查到这一步，意味着这个数据是执行到查询了，这可以直接设置为true
        return new R(true,ibookService.list());
    }

    //添加 根据json数据改的 所以传的是 @RequestBody
    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        //R r=new R();
        //boolean flag=ibookService.save(book);
        //r.setFlag(flag);

        //if(book.getName().equals("123"))  throw new IOException();
        boolean flag = ibookService.save(book);
        //三目运算
        return new R(flag,flag?"添加成功^_^":"添加失败-_-!");
    }

    //修改
    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(ibookService.modifyBook(book));
    }

    //删除  http://localhost:8080/books/7
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(ibookService.deleteBookById(id));
    }

    //查单个 根据路径的id查找 还要加参数来源
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, ibookService.getById(id));
    }

    //分页操作
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        IPage<Book> page = ibookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage>page.getPages()){
            page=ibookService.getPage((int) page.getPages(), pageSize,book);
        }
        return new R(true, page);
    }
}
