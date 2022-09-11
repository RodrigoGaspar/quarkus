package dev.rodgaspar.entity;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;

import dev.rodgaspar.adapters.converters.VehicleConverter;
import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.core.ports.VehicleEntityPort;

@ApplicationScoped
public class VehicleEntityHandler implements VehicleEntityPort {

    @Override
    public List<VehicleModel> findAll() {
        List<Vehicle> vehicles = Vehicle.listAll();
        return VehicleConverter.toModelList(vehicles);
    }

    @Override
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

    @Override
    public VehicleModel save(VehicleModel vehicleModel) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(vehicleModel.getModel());
        vehicle.setType(vehicleModel.getType());
        vehicle.setYear(vehicleModel.getYear());
        vehicle.setManufacturer(vehicleModel.getManufacturer());
        vehicle.persist();
        return VehicleConverter.toModel(vehicle);
    }
   
}
