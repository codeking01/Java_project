package com.king.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author codeking
 * @date 2022/4/10 22:45
 */
@Data
@ToString
@AllArgsConstructor //有参
@NoArgsConstructor //无参
public class UserEntity {
    private String userName;
    private Integer age;
}