package com.example.wikipediagraphbackend.rest;

import com.example.wikipediagraphbackend.entity.Page;
import com.example.wikipediagraphbackend.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(path="/pages")
public class PageEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public PageService service;

    public PageEndpoint(PageService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public Page getPage(@PathVariable("id") Long id) {
        LOGGER.info("GET /{id}",id);
        try {
            return service.getOneById(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            LOGGER.error("ServiceException", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
