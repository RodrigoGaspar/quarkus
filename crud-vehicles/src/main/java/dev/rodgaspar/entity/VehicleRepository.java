package dev.rodgaspar.entity;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import dev.rodgaspar.adapters.converters.VehicleConverter;
import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.core.ports.VehicleDomainPort;

@ApplicationScoped
public class VehicleRepository implements VehicleDomainPort {

    @Override
    public List<VehicleModel> findAll() {
        List<Vehicle> vehicles = Vehicle.listAll();
        return VehicleConverter.toModel(vehicles);
    }

    @Override
    @Transactional
    public VehicleModel update(VehicleModel vehicleModel) {
        Vehicle vehicle = Vehicle.findById(vehicleModel.getId());
        if (vehicle == null)
            throw new NotFoundException("Vehicle not found!!");

        vehicle.setModel(vehicleModel.getModel());
        vehicle.setType(vehicleModel.getType());
        vehicle.setYear(vehicleModel.getYear());
        vehicle.setManufacturer(vehicleModel.getManufacturer());

        return VehicleConverter.toModel(vehicle);
    }
   
}
