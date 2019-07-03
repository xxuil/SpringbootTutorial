package com.learn.springboot.aop;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    private final Log logger = LogFactory.getLog(getClass());

    @Before("execution( * com.learn.controller.UserController.login(..))")
    public void loginLogAspect(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toString();
        String args = joinPoint.getArgs().toString();
        logger.info("---Before method "
                + method + " invoke, param: " + args + "---");
    }
}
