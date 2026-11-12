
package com.site.aspect_oriented_programming.aspect;

import com.site.aspect_oriented_programming.annotation.TrackExecutionTime;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(2)
public class PerformanceAspect {

    @Around("@annotation(com.site.aspect_oriented_programming.annotation.TrackExecutionTime)")
    public Object measureExecutionTime(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.nanoTime();

        try {
            return proceedingJoinPoint.proceed();
        } finally {

            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1_000_000;

            log.info("Method {} took {} ms to execute",
                    proceedingJoinPoint.getSignature().getName(),
                    duration);
        }
    }
}
