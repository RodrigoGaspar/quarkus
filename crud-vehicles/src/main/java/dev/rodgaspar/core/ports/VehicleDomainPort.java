package dev.rodgaspar.core.ports;

import java.util.List;

import dev.rodgaspar.domain.Vehicle;

public interface VehicleDomainPort {
    
    List<Vehicle> findAll();
}
