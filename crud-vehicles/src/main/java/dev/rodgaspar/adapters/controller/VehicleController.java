package dev.rodgaspar.adapters.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;

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

        return RestResponse.ok(VehicleConverter.toDtoList(carros));
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public RestResponse<VehicleDto> updateVehicle(@RestPath int id,
                                                  VehicleDto vehicleDto){
        vehicleDto.setId(id);
        var vehicleModel = VehicleConverter.toModel(vehicleDto);
        var vehicle = vehicleBusinessPort.update(vehicleModel);
        return RestResponse.ok(VehicleConverter.toDto(vehicle));
    }

    @POST
    @Transactional
    public RestResponse<VehicleDto> createVehicle(VehicleDto vehicleDto){
        var vehicleModel = VehicleConverter.toModel(vehicleDto);
        var vehicle = vehicleBusinessPort.create(vehicleModel);

        return RestResponse.status(Status.CREATED, VehicleConverter.toDto(vehicle));
    }
}