package org.example.controllers;

import org.bson.types.ObjectId;
import org.example.models.dtos.NewsDTO;
import org.example.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping
    public ResponseEntity<List<NewsDTO>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> findById(@PathVariable("id") ObjectId id) {
        return service.findOne(id);
    }

    @PostMapping
    public ResponseEntity<NewsDTO> create(@RequestBody NewsDTO newsDTO) {
        return service.save(newsDTO);
    }

    @PutMapping
    public ResponseEntity<NewsDTO> update(@RequestBody NewsDTO newsDTO) {
        return service.update(newsDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") ObjectId id) {
        return service.delete(id);
    }

}