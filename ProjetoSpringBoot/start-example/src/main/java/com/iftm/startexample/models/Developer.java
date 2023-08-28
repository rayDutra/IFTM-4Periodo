package com.iftm.startexample.models;

import com.iftm.startexample.models.dtos.AddressDTO;
import com.iftm.startexample.models.dtos.SectorDTO;
import org.bson.types.ObjectId;

import java.util.Objects;

public class Developer {
    private ObjectId id;
    private String name;
    private String lastName;
    private String level;
    private String specialization;
    private SectorDTO sector;
    private AddressDTO address;

    public Developer() {
    }

    public Developer(ObjectId id, String name, String lastName, String level, String specialization, SectorDTO sector, AddressDTO address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.level = level;
        this.specialization = specialization;
        this.sector = sector;
        this.address = address;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
        Developer developer = (Developer) o;
        return Objects.equals(id, developer.id) && Objects.equals(name, developer.name) && Objects.equals(lastName, developer.lastName) && Objects.equals(level, developer.level) && Objects.equals(specialization, developer.specialization) && Objects.equals(sector, developer.sector) && Objects.equals(address, developer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, level, specialization, sector, address);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", specialization='" + specialization + '\'' +
                ", sector=" + sector +
                ", address=" + address +
                '}';
    }
}
