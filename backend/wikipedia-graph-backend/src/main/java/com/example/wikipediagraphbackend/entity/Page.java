package com.example.wikipediagraphbackend.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Page {

    @Id
    @GeneratedValue
    private long pageId;
    private String title;

    public Page() {}

    public String getTitle() {
        return title;
    }

    public long getPageId() {
        return pageId;
    }

    public void setTitle() {
        this.title = title;
    }
}
