package dev.rodgaspar.core.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VehicleModel {

    private long id;

    private String model;
    
    private String type;

    private int year;

    private String manufacturer;

}
