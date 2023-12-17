package com.iftm.cassandra;


import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table(value = "tb_imovel")
public class Imovel implements Serializable {
    @Id
    @PrimaryKey
    private UUID id;

    @Column
    private String endereco;

    @Column
    private String tipoImovel;

    @Column
    private double area;

    @Column
    private double preco;

    public Imovel() {
        this.id = Uuids.timeBased();
    }

    public Imovel(UUID id, String endereco, String tipoImovel, double area, double preco) {
        this.id = id;
        this.endereco = endereco;
        this.tipoImovel = tipoImovel;
        this.area = area;
        this.preco = preco;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

