package com.tensquare.article.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.util.IdWorker;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    public List<Article> findAll() {
        return articleDao.selectList(null);
    }

    public Article findById(String id) {
        return articleDao.selectById(id);
    }

    public void add(Article article) {
        article.setId(idWorker.nextId() + "");
        articleDao.insert(article);
    }

    public void update(Article article) {
        articleDao.updateById(article);
        QueryWrapper<Article> wrapper = new QueryWrapper<Article>();
        wrapper.eq("id",article.getId());
        articleDao.update(article, wrapper);

    }

    public void delete(String id) {
        articleDao.deleteById(id);
    }

    public Page<Article> findByPage(Map<String, Object> map, Integer page, Integer size) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<Article>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            queryWrapper.eq(map.get(key) != null, key, map.get(key));
        }
        Page<Article> pageData = new Page<>(page, size);

        Page<Article> articlePage = articleDao.selectPage(pageData, queryWrapper);

        List<Article> records = articlePage.getRecords();
        pageData.setRecords(records);
        return pageData;
    }




}
