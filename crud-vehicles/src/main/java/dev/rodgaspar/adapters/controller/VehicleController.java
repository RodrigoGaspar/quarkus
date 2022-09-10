package dev.rodgaspar.adapters.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import dev.rodgaspar.adapters.converters.VehicleConverter;
import dev.rodgaspar.adapters.dto.VehicleDto;
import dev.rodgaspar.core.ports.VehicleBusinessPort;

@Path("/vehicle")
@Consumes("application/json")
public class VehicleController {

    @Inject
    VehicleBusinessPort vehicleBusinessPort;

    @GET
    public RestResponse<List<VehicleDto>> listAll() {

        var carros = vehicleBusinessPort.listAll();
        var carrosDto = VehicleConverter.toDto(carros);

        return RestResponse.ok(carrosDto);
    }

    @PUT
    @Path("/{id}")
    public RestResponse<VehicleDto> updateVehicle(@RestPath int id,
                                                  VehicleDto vehicleDto){
        var vehicleModel = VehicleConverter.toModel(id, vehicleDto);
        var vehicle = vehicleBusinessPort.update(vehicleModel);
        vehicleDto = VehicleConverter.toDto(vehicle);
        return RestResponse.ok(vehicleDto);
    }

    @POST
    public RestResponse<VehicleDto> createVehicle(){
        return null;
    }
}