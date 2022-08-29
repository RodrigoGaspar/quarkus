package dev.rodgaspar.core.biz;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dev.rodgaspar.core.ports.VehicleBusinessPort;
import dev.rodgaspar.core.ports.VehicleDomainPort;
import dev.rodgaspar.domain.Vehicle;

@ApplicationScoped
public class CarroBusiness implements VehicleBusinessPort {

    @Inject
    VehicleDomainPort vehicleDomain;

    @Override
    public List<Vehicle> listAll() {
        return vehicleDomain.findAll();
    }

}
