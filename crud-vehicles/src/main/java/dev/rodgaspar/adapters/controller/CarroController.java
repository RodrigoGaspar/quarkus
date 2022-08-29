package dev.rodgaspar.adapters.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestResponse;

import dev.rodgaspar.adapters.converters.VehicleConverter;
import dev.rodgaspar.adapters.dto.VehicleDto;
import dev.rodgaspar.core.ports.VehicleBusinessPort;

@Path("/vehicle")
public class CarroController {

    @Inject
    VehicleBusinessPort carroBusinessPort;

    @GET
    public RestResponse<List<VehicleDto>> listAll() {

        var carros = carroBusinessPort.listAll();
        var carrosDto = VehicleConverter.modelToDto(carros);

        return RestResponse.ok(carrosDto);
    }
}