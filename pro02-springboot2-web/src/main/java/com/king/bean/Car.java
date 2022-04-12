package com.king.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 只有容器中的组件，才会拥有SpringBoot提供的强大的功能
 */
//lombok简化 构造器，setget，tostring
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private BigDecimal price;

}
