package dev.rodgaspar.adapters.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestResponse;

import dev.rodgaspar.adapters.converters.CarrosConverter;
import dev.rodgaspar.adapters.dto.CarrosDto;
import dev.rodgaspar.core.ports.CarroBusinessPort;

@Path("/carros")
public class CarroController {

    @Inject
    CarroBusinessPort carroBusinessPort;

    @GET
    public RestResponse<CarrosDto> listAll() {

        var carros = carroBusinessPort.listAll();
        var carrosDto = CarrosConverter.modelToDto(carros);

        return RestResponse.ok(carrosDto);
    }
}