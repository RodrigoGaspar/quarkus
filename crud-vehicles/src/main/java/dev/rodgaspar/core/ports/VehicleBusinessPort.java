package dev.rodgaspar.core.ports;

import java.util.List;

import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.domain.Vehicle;

public interface VehicleBusinessPort {
    
    List<Vehicle> listAll();

}
