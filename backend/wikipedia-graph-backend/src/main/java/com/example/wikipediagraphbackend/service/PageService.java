package com.example.wikipediagraphbackend.service;

import com.example.wikipediagraphbackend.entity.Page;

public interface PageService {
    /**
     * Finds a Page stored in the system by its given id
     * @param id
     * @return the Page with the given id
     */
    Page getOneById(Long id);
}
