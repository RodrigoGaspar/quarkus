package dev.rodgaspar.core.ports;

import java.util.List;

import dev.rodgaspar.core.model.VehicleModel;

public interface VehicleBusinessPort {
    
    List<VehicleModel> listAll();

    VehicleModel update(VehicleModel vehicleModel);

    VehicleModel create(VehicleModel vehicleModel);

    void delete(VehicleModel vehicleModel);

    List<VehicleModel> listVehicles(String type);
}
