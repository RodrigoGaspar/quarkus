package dev.rodgaspar.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
