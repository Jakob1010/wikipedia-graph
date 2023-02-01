package com.example.wikipediagraphbackend.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Page")
public class Article {

    @Id
    @GeneratedValue
    private long pageId;

    @Property("title")
    private String title;

    public Article() {}

    public String getTitle() {
        return title;
    }

    public long getPageId() {
        return pageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
