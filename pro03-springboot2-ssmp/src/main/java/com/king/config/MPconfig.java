package com.king.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author codeking
 * @date 2022/4/13 10:37
 */
@Configuration
public class MPconfig {
    //配置拦截器控制分页
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //1.定义Mp拦截器
        MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
        //2.添加具体的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
