package com.king.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.king.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author codeking
 * @date 2022/4/12 21:48
 */
@Mapper
//记得加上泛型 这样的话 它可以指定操作的是哪个
public interface BookDao extends BaseMapper<Book> {
    // 纯手写的数据库操作的方法
    // @Select("select * from tbl_book where id =#{id}")
    // Book getById(Integer id);
}
