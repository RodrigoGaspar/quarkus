package dev.rodgaspar.domain;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.rodgaspar.core.ports.VehicleDomainPort;

@ApplicationScoped
public class VehicleDomain implements VehicleDomainPort {

    @Override
    public List<Vehicle> findAll() {
        return Vehicle.listAll();
    }
   
}
