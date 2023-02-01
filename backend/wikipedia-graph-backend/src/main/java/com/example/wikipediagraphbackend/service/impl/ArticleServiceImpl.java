package com.example.wikipediagraphbackend.service.impl;
import com.example.wikipediagraphbackend.persistence.ArticleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.wikipediagraphbackend.entity.Article;
import com.example.wikipediagraphbackend.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class ArticleServiceImpl implements ArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ArticleDao dao;

    public ArticleServiceImpl(ArticleDao dao) {
        this.dao = dao;
    }

    @Override
    public Article getOneById(Long id) {
        LOGGER.debug("getOneById id:{}",id);
        Article page = null;
        try {
            page =  dao.findByPageId(id);
            LOGGER.info(page.getPageId() + "");
            return page;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return page;
        }
    }

    @Override
    public Page<Article> findAllByTitle(String title, Pageable page) {
        LOGGER.debug("findAllByTitle title:{}",title);
        Page p = null;
        try {
            p = dao.findAllByTitleIgnoreCaseContaining(title, page);
            return p;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return p;
        }
    }
}
