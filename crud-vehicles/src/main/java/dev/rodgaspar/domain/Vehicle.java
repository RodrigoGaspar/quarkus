package dev.rodgaspar.domain;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;

@Getter
@Entity
public class Vehicle extends PanacheEntity{

    public String modelo;

    public int ano;

    public String fabricante;

}
