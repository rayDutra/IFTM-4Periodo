package com.iftm.startexample.models.dtos;

import java.util.Objects;

public class AddressDTO {
    private String street;
    private int number;
    private String city;
    private String country;

    public AddressDTO() {
    }

    public AddressDTO(String street, int number, String city, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO that = (AddressDTO) o;
        return number == that.number && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, city, country);
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}

