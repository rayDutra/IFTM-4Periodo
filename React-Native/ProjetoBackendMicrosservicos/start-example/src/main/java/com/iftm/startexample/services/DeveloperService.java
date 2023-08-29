package com.iftm.startexample.services;

import com.iftm.startexample.models.Developer;
import com.iftm.startexample.models.dtos.DeveloperDTO;
import com.iftm.startexample.models.dtos.UserDTO;
import com.iftm.startexample.repositories.DeveloperRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperService {
    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public ResponseEntity<List<DeveloperDTO>> findAll() {
        var dbDevelopers = developerRepository.findAll();
        if (dbDevelopers.isEmpty())
            return ResponseEntity.notFound().build();

        var developerDtos = dbDevelopers.stream().map(developer -> {
            return new DeveloperDTO(developer);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(developerDtos);
    }
    public ResponseEntity<DeveloperDTO> findById(ObjectId id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        var dbDeveloper = developerRepository.findById(id);

        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new DeveloperDTO(dbDeveloper.get()));
    }

    public ResponseEntity<DeveloperDTO> save(Developer developer) {
        // validar developer
        if (developer.getName().isBlank() || developer.getLastName().isBlank())
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(new DeveloperDTO(developerRepository.save(developer)));
    }

    public ResponseEntity<DeveloperDTO> update(DeveloperDTO developerDTO) {
        if (developerDTO.getId() == null)
            return ResponseEntity.badRequest().build();

        var dbDeveloper = developerRepository.findById(new ObjectId(developerDTO.getId()));

        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        var dbDeveloperObj = dbDeveloper.get();
        dbDeveloperObj.setName(developerDTO.getName());
        dbDeveloperObj.setLastName(developerDTO.getLastName());
        dbDeveloperObj.setSpecialization(developerDTO.getSpecialization());
        dbDeveloperObj.setLevel(developerDTO.getLevel());

        var tempDTO = developerDTO.toDeveloper();
        dbDeveloperObj.setSector(tempDTO.getSector());
        dbDeveloperObj.setAddress(tempDTO.getAddress());

        var updatedDeveloper = developerRepository.save(dbDeveloperObj);
        return ResponseEntity.ok(new DeveloperDTO(updatedDeveloper));
    }

    public void delete(ObjectId id) {
        if (id == null)
            return;

        developerRepository.deleteById(id);
    }
}
