package com.example.aop.service;

import com.example.aop.aop.BookAop;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AopConfig {
    @Bean
    public BookServiceImpl bookService(){
        return new BookServiceImpl();
    }
    @Bean
    public BookAop bookAop(){
        return new BookAop();
    }

}
