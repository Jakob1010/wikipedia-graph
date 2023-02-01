package com.example.wikipediagraphbackend.service;

import com.example.wikipediagraphbackend.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ArticleService {
    /**
     * Finds an Article stored in the system by its given id
     * @param id
     * @return the Article with the given id
     */
    Article getOneById(Long id);

    /**
     * Finds an Article stored in the system by its title
     * @param title
     * @return the Article with the given id
     */
    Page<Article> findAllByTitle(String title, Pageable page);
}
