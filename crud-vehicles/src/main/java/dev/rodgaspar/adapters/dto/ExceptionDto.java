package dev.rodgaspar.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class ExceptionDto {

    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;
    
}
