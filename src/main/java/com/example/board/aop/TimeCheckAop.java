package com.example.board.aop;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeCheckAop {
    @Around("@annotation(TimeCheck)")
    public Object timeCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        Object proceed=joinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long result = end-start;
        System.out.println("실행시간"+result+"ms");
        return proceed;
    }
}
