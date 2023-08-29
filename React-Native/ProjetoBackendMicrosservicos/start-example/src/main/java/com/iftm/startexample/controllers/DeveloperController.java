package com.iftm.startexample.controllers;

import com.iftm.startexample.models.Developer;
import com.iftm.startexample.models.dtos.DeveloperDTO;
import com.iftm.startexample.models.dtos.UserDTO;
import com.iftm.startexample.services.DeveloperService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/developers")
public class DeveloperController {
    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> findAll(){
        return developerService.findAll();
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> createDeveloper(@RequestBody DeveloperDTO developerDTO) {
        return developerService.save(developerDTO.toDeveloper());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<DeveloperDTO> findById(@PathVariable ObjectId id) {
        return developerService.findById(id);
    }

    @PutMapping
    public ResponseEntity<DeveloperDTO> updateDeveloper(@RequestBody DeveloperDTO developerDTO) {
        return developerService.update(developerDTO);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") ObjectId id) {
        developerService.delete(id);
        return ResponseEntity.ok().build();
    }

}
