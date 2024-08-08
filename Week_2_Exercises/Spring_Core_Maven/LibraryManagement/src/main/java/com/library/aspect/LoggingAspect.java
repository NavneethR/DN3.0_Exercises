package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.*(..))")
    public void beforeAdvice() {
        System.out.println("Executing method in BookService - Before Advice");
    }

    @After("execution(* com.library.service.BookService.*(..))")
    public void afterAdvice() {
        System.out.println("Executed method in BookService - After Advice");
    }
}
