package com.king.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author codeking
 * @date 2022/4/11 23:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
//封装前置的对象
@ConfigurationProperties(prefix = "enterprise")
public class testdata {
    private String name;
    private Integer age;
    private BigDecimal tel;
    private String[] subject;
}
// enterprise:
//         name:itcast
//         age:16
//         tel:4006184000
//         subject:
//         -Java
//         -前端
//         -大数据