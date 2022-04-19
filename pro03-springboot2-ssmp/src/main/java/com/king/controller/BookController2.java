package com.king.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.king.controller.utils.R;
import com.king.domain.Book;
import com.king.service.BookService;
import com.king.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public R save(@RequestBody Book book) {
        //R r=new R();
        //boolean flag=ibookService.save(book);
        //r.setFlag(flag);
        return new R(ibookService.save(book));
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
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(true, ibookService.getPage(currentPage, pageSize));
    }
}
