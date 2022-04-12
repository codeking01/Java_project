package com.king.dao;

import com.king.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author codeking
 * @date 2022/4/12 17:10
 */

//这个是mybatis的做法
@Mapper
public interface BookDao {
    public void save();
    // 这个是整合mybatis的写法 mybatis plus 的写法不一样
    @Select("select * from tbl_book where  id =#{id}")
    public Book getById(Integer id);
}


//下面的是 mybatis plus 的整合
// @Mapper
// public interface BookDao extends BaseMapper<Book>{
//
// }