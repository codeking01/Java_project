package com.king.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author codeking
 * @date 2022/4/12 20:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//配置表名
// @TableName("tbl_book")   ======>这个是mybatis plus 修改表名的做法
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
