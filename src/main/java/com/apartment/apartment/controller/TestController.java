package com.apartment.apartment.controller;

import com.apartment.apartment.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private TestDao testDao;

    @GetMapping("/hello")
    public String print() {
        return "Hello World";
    }

    @PostMapping
    public String put() {
        testDao.put();
        return "Put";
    }

    @GetMapping
    public String get() {
        return "ID --> " + testDao.get();
    }
}
