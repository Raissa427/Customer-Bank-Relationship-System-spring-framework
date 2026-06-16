package com.igirepay.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.igirepay.service.BankManager.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[LoggingAspect - BEFORE] Entering method: " + methodName + "()");
    }

    @After("execution(* com.igirepay.service.BankManager.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[LoggingAspect - AFTER] Exiting method: " + methodName + "() completed.");
    }
}
