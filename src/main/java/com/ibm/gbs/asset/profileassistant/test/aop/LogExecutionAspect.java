package com.ibm.gbs.asset.profileassistant.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionAspect {
    private Logger logger = LoggerFactory.getLogger("pa-app-aop-logger");

    @Around("@annotation(LogExecution)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String targetName = joinPoint.getTarget().getClass().getCanonicalName();
        this.logger.trace("-- start (" + targetName +") --");
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        this.logger.trace("-- end (" + targetName + " executed in " + executionTime + "ms) --");
        return proceed;
    }

}
