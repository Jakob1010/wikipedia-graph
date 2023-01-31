package com.example.wikipediagraphbackend.persistence;

import com.example.wikipediagraphbackend.entity.Article;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ArticleDao extends Neo4jRepository<Article, Long> {
    Article findByPageId(long id);
    Page<Article> findAll(Pageable pageable);
}
