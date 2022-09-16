package com.example.wikipediagraphbackend.service.impl;
import com.example.wikipediagraphbackend.persistence.PageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.wikipediagraphbackend.entity.Page;
import com.example.wikipediagraphbackend.service.PageService;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class PageServiceImpl implements PageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final PageDao dao;

    public PageServiceImpl(PageDao dao) {
        this.dao = dao;
    }

    @Override
    public Page getOneById(Long id) {
        LOGGER.debug("getOneById id:{}",id);
        Page page = null;
        try {
            page =  dao.findByPageId(id);
            LOGGER.info(page.getPageId() + "");
            return page;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return page;
        }
    }
}
