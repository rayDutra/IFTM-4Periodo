package com.iftm.startexample.feign;

import com.iftm.startexample.models.dtos.AnnualWageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "company-calculations", fallback = CompanyCalculationsFallback.class)
public interface CompanyCalculationsClient {

    @GetMapping("/calculate-annual-wage/{employee-id}")
    AnnualWageDTO calculateAnnualWage(@PathVariable("employee-id") String employeeId);
}
