package dev.rodgaspar.adapters.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;

import dev.rodgaspar.adapters.converters.VehicleConverter;
import dev.rodgaspar.adapters.dto.VehicleDto;
import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.core.ports.VehicleBusinessPort;
import io.quarkus.logging.Log;

@Path("/vehicle")
@Consumes("application/json")
public class VehicleController {

    @Inject
    VehicleBusinessPort vehicleBusiness;

    @GET
    public RestResponse<List<VehicleDto>> listVehicles(@RestQuery String type) {

        var vehicles = vehicleBusiness.listVehicles(type);

        return RestResponse.ok(VehicleConverter.toDtoList(vehicles));
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public RestResponse<VehicleDto> updateVehicle(@RestPath long id,
                                                  @Valid VehicleDto vehicleDto){
        vehicleDto.setId(id);
        var vehicleModel = VehicleConverter.toModel(vehicleDto);
        var vehicle = vehicleBusiness.update(vehicleModel);
        return RestResponse.ok(VehicleConverter.toDto(vehicle));
    }

    @POST
    @Transactional
    public RestResponse<VehicleDto> createVehicle(@Valid VehicleDto vehicleDto){
        var vehicleModel = VehicleConverter.toModel(vehicleDto);
        var vehicle = vehicleBusiness.create(vehicleModel);

        return RestResponse.status(Status.CREATED, VehicleConverter.toDto(vehicle));
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public RestResponse deleteVehicle(@RestPath long id){
        Log.info("Executing deleteVehicle...");
        var vehicleModel = VehicleModel.builder().id(id).build();
        vehicleBusiness.delete(vehicleModel);
        return RestResponse.ok();
    }


}