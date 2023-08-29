package com.iftm.startexample.models.dtos;

import com.iftm.startexample.models.Sector;

import java.util.Objects;

public class SectorDTO {
    private String name;
    private int floor;

    public SectorDTO() {
    }

    public SectorDTO(String name, int floor) {
        this.name = name;
        this.floor = floor;
    }
    public SectorDTO(Sector sector) {
        this.name = sector.getName();
        this.floor = sector.getFloor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectorDTO sectorDTO = (SectorDTO) o;
        return floor == sectorDTO.floor && Objects.equals(name, sectorDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, floor);
    }

    @Override
    public String toString() {
        return "SectorDTO{" +
                "name='" + name + '\'' +
                ", floor=" + floor +
                '}';
    }
}
