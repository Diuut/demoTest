package com.diuut.ddt.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Diuut
 * @Date 2022/9/4  23:23
 */
@Aspect
@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    /**
     * 以 controller 包下定义的所有请求为切入点
     */
    @Pointcut(value = "execution(public * com.diuut.ddt.controller..*.*(..))")
    public void reqOpenAPILog() {
    }
    /**
     * 在切点之前织入
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("reqOpenAPILog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求 url
        log.info("Request URL    : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("Request IP     : {}", request.getRemoteAddr());
        // 打印请求入参
        ObjectMapper mapper = new ObjectMapper();
        String args = mapper.writeValueAsString(joinPoint.getArgs());
        Object jsonObject = mapper.readValue(args, Object.class);
        log.info("Request Args   : {}",  jsonObject);
    }
        /**
         * 在切点之后织入
         *
         * @throws Throwable
         */
        @After("reqOpenAPILog()")
        public void doAfter() throws Throwable {

        }
        /**
         * 环绕
         *
         * @param proceedingJoinPoint
         * @return
         * @throws Throwable
         */
        @Around("reqOpenAPILog()")
        public Object doAround (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            log.info("========================== Start ==========================");
            long startTime = System.currentTimeMillis();
            Object result = proceedingJoinPoint.proceed();
            // 打印出参
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValueAsString(result);
            log.info("Response Args  : {}", mapper.writeValueAsString(result));
            // 执行耗时
            log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
            log.info("========================== End ==========================");
            return result;
        }


    }