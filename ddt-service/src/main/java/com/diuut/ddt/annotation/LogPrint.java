package com.diuut.ddt.annotation;

import java.lang.annotation.*;

/**
 * @Author: 23133
 * @Date: 2021/3/25 17:54
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogPrint {
}
