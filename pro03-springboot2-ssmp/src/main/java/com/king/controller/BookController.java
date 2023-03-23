package com.king.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.king.domain.Book;
import com.king.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codeking
 * @date 2022/4/19 10:12
 */

//@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService ibookService;

    @GetMapping
    public List<Book> getAll() {
        return ibookService.list();
    }

    //添加 根据json数据改的 所以传的是 @RequestBody
    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return ibookService.save(book);
    }

    //修改
    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return ibookService.modifyBook(book);
    }

    //删除  http://localhost:8080/books/7
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id) {
        return ibookService.deleteBookById(id);
    }

    //查单个 根据路径的id查找 还要加参数来源
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return ibookService.getById(id);
    }

    //分页操作
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return ibookService.getPage(currentPage, pageSize);
    }
}
