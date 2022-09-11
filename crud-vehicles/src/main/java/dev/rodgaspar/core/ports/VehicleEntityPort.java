package dev.rodgaspar.core.ports;

import java.util.List;

import dev.rodgaspar.core.model.VehicleModel;

public interface VehicleEntityPort {
    
    List<VehicleModel> findAll();

    VehicleModel update(VehicleModel vehicleModel);

    VehicleModel save(VehicleModel vehicleModel);
}
