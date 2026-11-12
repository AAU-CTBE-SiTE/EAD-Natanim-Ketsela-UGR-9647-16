
package com.site.aspect_oriented_programming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(3)
public class ExceptionAspect {

    @AfterThrowing(
            pointcut = "execution(* com.site.aspect_oriented_programming.service.*.*(..))",
            throwing = "exception"
    )
    public void logException(
            JoinPoint joinPoint,
            Throwable exception) {

        log.error("Exception in method {}: {}",
                joinPoint.getSignature().getName(),
                exception.getMessage());
    }
}
