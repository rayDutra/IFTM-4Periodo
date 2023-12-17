package com.iftm.cassandra;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<Imovel> create(@RequestBody Imovel imovel) {
        return imovelService.create(imovel);
    }


    @GetMapping
    public ResponseEntity<List<Imovel>> findAll() {
        return imovelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> findById(@PathVariable UUID id) {
        return imovelService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> update(@PathVariable UUID id, @RequestBody Imovel imovel) {
        return imovelService.update(id, imovel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") UUID id) {
       return imovelService.delete(id);
    }
}
