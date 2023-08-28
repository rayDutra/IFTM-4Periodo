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
@RequestMapping("/developers")
public class DeveloperController {
    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> createDeveloper(@RequestBody DeveloperDTO developerDTO) {
        Developer developer = new Developer();
        // Não é necessário definir o ID aqui, pois o serviço fará isso
        developer.setName(developerDTO.getName());
        developer.setLastName(developerDTO.getLastName());
        developer.setLevel(developerDTO.getLevel());
        developer.setSpecialization(developerDTO.getSpecialization());
        developer.setSector(developerDTO.getSector());
        developer.setAddress(developerDTO.getAddress());

        return developerService.save(developer);
    }
    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> getAllDevelopers() {
        return developerService.findAll();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<DeveloperDTO> findById(@PathVariable ObjectId id) {
        return developerService.findById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DeveloperDTO> updateDeveloper(@PathVariable ObjectId id, @RequestBody DeveloperDTO developerDTO) {
        developerDTO.setId(id.toString());  // Converte o ObjectId para String
        return developerService.update(developerDTO);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") ObjectId id) {
        developerService.delete(id);
        return ResponseEntity.ok().build();
    }

}
