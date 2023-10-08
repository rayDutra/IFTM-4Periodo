package com.logs.startexample.controllers;
import com.logs.startexample.models.dtos.EmployeeDTO;
import com.logs.startexample.models.dtos.LogDTO;
import com.logs.startexample.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logs")
public class LogController {

    @Autowired
    private LogService service;

    @GetMapping
    public ResponseEntity<List<LogDTO<EmployeeDTO>>> findAll() {
        return service.findAll();
    }
}