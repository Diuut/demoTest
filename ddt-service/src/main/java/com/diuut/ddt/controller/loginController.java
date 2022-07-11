package com.diuut.ddt.controller;

import com.diuut.ddt.pojo.Person;
import commonUtils.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

/**
 * @Author Diuut
 * @Date 2022/7/11 22:28
 */
@Slf4j
@RestController
@CrossOrigin
public class loginController {
    @RequestMapping("/hello")
    public BaseResult hello() {
        return BaseResult.ok("hello world");
    }
    @RequestMapping("/hi")
    public BaseResult handle01(@RequestParam("name") String name) {
        log.info("请求进来了....");
        Person person = new Person();
        person.setName(name);
        person.setAge(24);
        person.setDate(new Date());
        person.setHeight(174);
        return BaseResult.ok("响应成功",person);
    }
}
