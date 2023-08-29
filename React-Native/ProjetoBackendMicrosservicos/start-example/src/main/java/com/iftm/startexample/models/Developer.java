package com.iftm.startexample.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.Objects;

@Document(collection = "developers")
public class Developer {
    @Id
    private ObjectId id;
    @Field("name")
    private String name;
    private String lastName;
    private String level;
    private String specialization;
    private Sector sector;
    private Address address;

    public Developer() {
    }

    public Developer(ObjectId id, String name, String lastName, String level, String specialization, Sector sector, Address address) {
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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
