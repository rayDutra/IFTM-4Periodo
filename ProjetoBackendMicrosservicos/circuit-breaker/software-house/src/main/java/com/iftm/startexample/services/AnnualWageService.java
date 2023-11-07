package com.iftm.startexample.services;

import com.iftm.startexample.feign.FeignConsumer;
import com.iftm.startexample.models.dtos.AnnualWageDTO;
import com.iftm.startexample.models.dtos.EmployeeDTO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AnnualWageService {
    @Autowired
    FeignConsumer feignConsumer;

    @Autowired
    EmployeeService employeeService;

    @Value("${eureka.instance.instance-id:}")
    private String instaceId;

    public ResponseEntity<AnnualWageDTO> getAnnualWage(ObjectId id) {
        ResponseEntity<EmployeeDTO> employee = employeeService.findById(id);

        if (employee.getBody() == null) {
            return ResponseEntity.notFound().build();
        }

        var response = feignConsumer.getResponse(employee.getBody());

        if(response.getBody() == null)
            ResponseEntity.internalServerError();

        return response;
    }
}