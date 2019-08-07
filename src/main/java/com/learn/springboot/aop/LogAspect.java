package com.learn.springboot.aop;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Administrator
 */
@Component
@Aspect
public class LogAspect {
    private final Log logger = LogFactory.getLog(getClass());

    @Before("execution( * com.learn.springboot.controller.UserController.login(..))")
    public void loginLogAspect(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("---Before method "
                + method + " invoke, param: " + args + "---");
    }
}
