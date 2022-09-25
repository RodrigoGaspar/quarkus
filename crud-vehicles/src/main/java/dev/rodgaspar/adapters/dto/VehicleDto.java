package dev.rodgaspar.adapters.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message="Model may not be blank!")
    private String model;

    @NotBlank(message="Type may not be blank!")
    private String type;

    @Min(message="Year may not be less than 1900!", value = 1900)
    private int year;

    @NotBlank(message="Manufacturer may not be blank!")
    private String manufacturer;

}
