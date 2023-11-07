package com.iftm.startexample.controllers;


import com.iftm.startexample.models.dtos.AnnualWageDTO;
import com.iftm.startexample.services.AnnualWageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/annual-wage")
public class AnnualWageController {

    @Autowired
    private AnnualWageService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<AnnualWageDTO> findById(@PathVariable("id") ObjectId id) {
        return service.getAnnualWage(id);
    }

}