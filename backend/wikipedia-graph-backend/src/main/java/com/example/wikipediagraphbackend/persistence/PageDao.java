package com.example.wikipediagraphbackend.persistence;

import com.example.wikipediagraphbackend.entity.Page;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PageDao extends Neo4jRepository<Page, Long> {
    Page findByPageId(long id);
    Page findPageByTitleContains(String s);
}
