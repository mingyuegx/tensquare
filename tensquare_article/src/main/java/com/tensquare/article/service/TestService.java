package com.tensquare.article.service;

import com.itheima.util.IdWorker;
import com.tensquare.article.pojo.Testdb;
import com.tensquare.article.reponsitory.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.Date;
import java.util.List;

@Service
public class TestService {



    @Autowired
    private IdWorker idWorker;

    @Autowired
    private TestRepository testRepository;

    public List<Testdb> findAll() {
        return testRepository.findAll();
    }

    public Testdb findById(String id) {
        return testRepository.findById(id).get();
    }

    public void save(Testdb testdb) {
        String id = idWorker.nextId() + "";
        testdb.set_id(id);

        testdb.setThumbup(0);
        testdb.setPublishdate(new Date());
        testRepository.save(testdb);
    }

    public void updateById(Testdb testdb) {
        testRepository.save(testdb);
    }

    public void deleteById(String id) {
        testRepository.deleteById(id);
    }

    public List<Testdb> findByArticleId(String articleId) {
        return testRepository.findByArticleid(articleId);
    }

    public void thumbup(String id) {
        Testdb db = testRepository.findById(id).get();
        db.setThumbup(db.getThumbup() + 1);
        testRepository.save(db);

    }
}
