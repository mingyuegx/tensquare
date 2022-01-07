package com.tensquare.article.controller;

import com.tensquare.article.pojo.Testdb;
import com.tensquare.article.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.itheima.entity.Result;
import src.main.java.com.itheima.entity.StatusCode;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "thumbup/{id}", method = RequestMethod.PUT)
    public Result thumbup(@PathVariable String id) {

        String userid = "123";
        Object result = redisTemplate.opsForValue().get("thumbup_" + userid + "_" + id);
        if (result != null) {
            return new Result(false, StatusCode.REMOTEERROR, "不能重复点赞"， null);
        }

        testService.thumbup(id);
        redisTemplate.opsForValue().set("thumbup_" + userid + "_" + id, 1);
        return new Result(true, StatusCode.OK, "点赞成功", null);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        Testdb testdb = testService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", testdb);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Testdb testdb) {
        testService.save(testdb);
        return new Result(true, StatusCode.OK, "新增成功", null);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Result updateById(@PathVariable String id, @RequestBody Testdb testdb) {
        testdb.set_id(id);
        testService.updateById(testdb);
        return new Result(true, StatusCode.OK, "修改成功", null);
    }

    public Result deleteById(@PathVariable String id) {
        testService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功", null);
    }




}
