package com.iftm.startexample.models.dtos;

public class AnnualWageDTO {
    private String firstName;
    private double annualWage;

    public AnnualWageDTO() { }

    public AnnualWageDTO(String firstName, double annualWage) {
        this.firstName = firstName;
        this.annualWage = annualWage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getAnnualWage() {
        return annualWage;
    }

    public void setAnnualWage(double annualWage) {
        this.annualWage = annualWage;
    }
// Getters e setters
}