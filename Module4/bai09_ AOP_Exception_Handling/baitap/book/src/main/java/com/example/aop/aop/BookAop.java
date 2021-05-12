package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BookAop {
    @After("execution(* com.example.aop.controller.BookController.showBook(..))")
    public void afterVisitLibrary(JoinPoint joinPoint){
        System.out.println("visit turn: " + joinPoint.getSignature().getName());
    }
    @After("execution(* com.example.aop.controller.BookController.showBorrowBook(..))")
    public void afterBorrow(JoinPoint joinPoint){
        System.out.println("visit turn: " + joinPoint.getSignature().getName());
    }
    @After("execution(* com.example.aop.controller.BookController.returnBook(..))")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("visit turn: " + joinPoint.getSignature().getName());
    }
}
