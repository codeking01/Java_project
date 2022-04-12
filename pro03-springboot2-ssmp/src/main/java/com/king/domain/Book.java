package com.king.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author codeking
 * @date 2022/4/12 21:30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Integer id;
    private  String type;
    private String name;
    private String description;
}
