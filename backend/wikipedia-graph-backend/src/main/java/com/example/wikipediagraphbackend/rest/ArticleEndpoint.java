package com.example.wikipediagraphbackend.rest;

import com.example.wikipediagraphbackend.entity.Article;
import com.example.wikipediagraphbackend.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(path=ArticleEndpoint.BASE_URL)
public class ArticleEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public static final String BASE_URL = "/api/v1/pages";
    public ArticleService service;

    public ArticleEndpoint(ArticleService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public Article getArticle(@PathVariable("id") Long id) {
        LOGGER.info("GET {}/{id}", BASE_URL, id);
        try {
            return service.getOneById(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            LOGGER.error("ServiceException", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping
    @PageableAsQueryParam
    @ResponseStatus(HttpStatus.OK)
    public Page<Article> getArticles(@RequestParam(name = "title") String title, Pageable pageable) {
        LOGGER.info("GET {}", BASE_URL);
        return service.findAllByTitle(title, pageable);
    }


}
