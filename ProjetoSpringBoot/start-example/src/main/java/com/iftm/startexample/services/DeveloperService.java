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
            var developerDTO = new DeveloperDTO(developer);
            return developerDTO;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(developerDtos);
    }

    public ResponseEntity<DeveloperDTO> findById(ObjectId id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        var dbDeveloper = developerRepository.findBy_id(id);

        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new DeveloperDTO(dbDeveloper.get()));
    }



    public ResponseEntity<DeveloperDTO> save(Developer developer) {
        // validar developer
        if (developer.getName().isBlank() || developer.getLastName().isBlank())
            return ResponseEntity.badRequest().build();

        developer.setId(new ObjectId());
        return ResponseEntity.ok(new DeveloperDTO(developerRepository.save(developer)));
    }

    public ResponseEntity<DeveloperDTO> update(DeveloperDTO developerDTO) {
        if (developerDTO.getId() == null)
            return ResponseEntity.badRequest().build();

        var objectId = new ObjectId(developerDTO.getId());
        var dbDeveloper = developerRepository.findBy_id(objectId);

        if (dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        var dbDeveloperObj = dbDeveloper.get();
        dbDeveloperObj.setName(developerDTO.getName());
        dbDeveloperObj.setLastName(developerDTO.getLastName());
        dbDeveloperObj.setLevel(developerDTO.getLevel());
        dbDeveloperObj.setSpecialization(developerDTO.getSpecialization());
        dbDeveloperObj.setSector(developerDTO.getSector());
        dbDeveloperObj.setAddress(developerDTO.getAddress());

        var updatedDeveloper = developerRepository.save(dbDeveloperObj);

        return ResponseEntity.ok(new DeveloperDTO(updatedDeveloper));
    }

    public void delete(ObjectId id) {
        if (id == null)
            return;

        developerRepository.deleteById(id.toString());
    }
}
