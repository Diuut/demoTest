package com.diuut.ddt.aspect;

import com.diuut.ddt.annotation.LogPrint;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * @Author Diuut
 * @Date 2020/6/1  10:49
 */
@Aspect
@Component
@Slf4j
public class LogPrintAspect {

    @Around(value = "@annotation(logPrint)")
    public Object around(ProceedingJoinPoint point, LogPrint logPrint) {
        Object proceed = null;
        //拦截的类名
        long start = System.currentTimeMillis();
        log.info("" + point.getTarget().getClass() + "." + point.getSignature().getName()+"模拟风险评估");
        try {
            proceed = point.proceed();
//            System.out.println(System.currentTimeMillis());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("" + point.getTarget().getClass() + "." + point.getSignature().getName()+"模拟事件上报");
        log.info("" + point.getTarget().getClass() + "." + point.getSignature().getName() + " 耗时 " + (end - start)
                + "毫秒");
        return proceed;
    }
}
