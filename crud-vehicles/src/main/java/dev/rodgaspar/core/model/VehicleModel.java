package dev.rodgaspar.core.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VehicleModel {

    private String modelo;

    private int ano;

    private String fabricante;

}
