package com.diuut.ddt.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author Diuut
 * @Date 2022/7/11 22:47
 */
@Data
public class Person {
    // 正常case
    private String name;
    // 空对象case
    private Integer age;
    // 日期转换case
    private Date date;
    // 默认值case
    private int height;
}