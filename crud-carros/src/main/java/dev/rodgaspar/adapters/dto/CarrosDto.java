package dev.rodgaspar.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class CarrosDto {
    
    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("ano")
    private int ano;

    @JsonProperty("fabricante")
    private String fabricante;

}
