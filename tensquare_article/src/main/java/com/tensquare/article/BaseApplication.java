package com.tensquare.article;

import com.itheima.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.tensquare.article.dao")
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);

    }

    @Bean
    public IdWorker createIdWorker() {
        return new IdWorker(1, 1);
    }

}
