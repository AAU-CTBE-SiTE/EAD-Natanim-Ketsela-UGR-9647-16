
package com.site.aspect_oriented_programming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(1)
public class LoggingAspect {

    // Reusable pointcut: all methods in the service package
    @Pointcut("execution(* com.site.aspect_oriented_programming.service.*.*(..))")
    public void paymentServiceMethods() {
    }

    // 1. Before method execution
    @Before("paymentServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {

        log.info("Executing method: {}",
                joinPoint.getSignature().getName());
    }

    // 2. After successful method execution
    @AfterReturning(
            pointcut = "paymentServiceMethods()",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        log.info("Method {} completed successfully. Returned: {}",
                joinPoint.getSignature().getName(),
                result == null ? "null" : result.getClass().getSimpleName());
    }

    // 3. After method execution, whether successful or exceptional
    @After("paymentServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {

        log.info("Finished executing method: {}",
                joinPoint.getSignature().getName());
    }
}
