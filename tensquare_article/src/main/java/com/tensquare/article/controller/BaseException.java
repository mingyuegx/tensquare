package com.tensquare.article.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import src.main.java.com.itheima.entity.Result;
import src.main.java.com.itheima.entity.StatusCode;

@ControllerAdvice
public class BaseException {

    @ExceptionHandler(value = Exception.class)
    public src.main.java.com.itheima.entity.Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage(), null);

    }
}
