package dev.rodgaspar.core.ports;

import java.util.List;

import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.entity.Vehicle;

public interface VehicleEntityPort {
    
    List<VehicleModel> findAll();

    VehicleModel update(VehicleModel vehicleModel);

    VehicleModel save(VehicleModel vehicleModel);

    void delete(VehicleModel vehicleModel);

    List<VehicleModel> getVehicles(String type);
}
