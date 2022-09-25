package dev.rodgaspar.core.model;

import dev.rodgaspar.adapters.constant.TypeEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VehicleModel {

    private long id;

    private String model;
    
    private TypeEnum type;

    private int year;

    private String manufacturer;

}
