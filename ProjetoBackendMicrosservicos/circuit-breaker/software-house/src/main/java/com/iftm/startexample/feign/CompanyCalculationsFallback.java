package com.iftm.startexample.feign;

import com.iftm.startexample.models.dtos.AnnualWageDTO;
import org.springframework.stereotype.Component;

@Component
public class CompanyCalculationsFallback implements CompanyCalculationsClient {

    @Override
    public AnnualWageDTO calculateAnnualWage(String employeeId) {
        return new AnnualWageDTO("Fallback", 0);
    }
}
