package com.example.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class interceptor {
    @Bean
    public MybatisPlusInterceptor interceptors(){
        MybatisPlusInterceptor mip = new MybatisPlusInterceptor();
        mip.addInnerInterceptor(new PaginationInnerInterceptor());
        mip.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mip;
    }
}
