package com.tensquare.article.reponsitory;

import com.tensquare.article.pojo.Testdb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TestRepository extends MongoRepository<Testdb, String> {
    List<Testdb> findByArticleid(String articleId);
}
