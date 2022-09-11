package dev.rodgaspar.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class VehicleDto {
    
    private long id;

    @JsonProperty("model")
    private String model;

    @JsonProperty("type")
    private String type;

    @JsonProperty("year")
    private int year;

    @JsonProperty("manufacturer")
    private String manufacturer;

}
