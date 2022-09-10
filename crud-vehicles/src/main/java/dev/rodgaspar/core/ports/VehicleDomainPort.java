package dev.rodgaspar.core.ports;

import java.util.List;

import dev.rodgaspar.core.model.VehicleModel;

public interface VehicleDomainPort {
    
    List<VehicleModel> findAll();

    VehicleModel update(VehicleModel vehicleModel);
}
