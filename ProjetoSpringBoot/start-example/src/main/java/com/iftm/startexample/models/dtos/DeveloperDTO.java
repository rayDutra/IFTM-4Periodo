package com.iftm.startexample.models.dtos;

import com.iftm.startexample.models.Developer;

import java.util.Objects;

public class DeveloperDTO {
    private String id;
    private String name;
    private String lastName;
    private String level;
    private String specialization;
    private SectorDTO sector;
    private AddressDTO address;

    public DeveloperDTO(Developer developer) {
    }

    public DeveloperDTO(String id, String name, String lastName, String level, String specialization, SectorDTO sector, AddressDTO address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.level = level;
        this.specialization = specialization;
        this.sector = sector;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public SectorDTO getSector() {
        return sector;
    }

    public void setSector(SectorDTO sector) {
        this.sector = sector;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeveloperDTO that = (DeveloperDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(level, that.level) && Objects.equals(specialization, that.specialization) && Objects.equals(sector, that.sector) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, level, specialization, sector, address);
    }

    @Override
    public String toString() {
        return "DeveloperDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", specialization='" + specialization + '\'' +
                ", sector=" + sector +
                ", address=" + address +
                '}';
    }

    // Getters and setters
}