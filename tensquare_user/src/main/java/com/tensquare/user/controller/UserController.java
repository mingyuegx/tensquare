package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.itheima.entity.Result;
import src.main.java.com.itheima.entity.StatusCode;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public Result login(@PathVariable String userId) {
        User user = userService.SelectById(userId);
        return new Result(true, StatusCode.OK, "查询成功", user);
    }



}
