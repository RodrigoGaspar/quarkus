package dev.rodgaspar.core.biz;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.core.ports.VehicleBusinessPort;
import dev.rodgaspar.core.ports.VehicleDomainPort;

@ApplicationScoped
public class VehicleBusiness implements VehicleBusinessPort {

    @Inject
    VehicleDomainPort vehicleDomain;

    @Override
    public List<VehicleModel> listAll() {
        return vehicleDomain.findAll();
    }

    @Override
    public VehicleModel update(VehicleModel vehicleModel) {
        return vehicleDomain.update(vehicleModel);
        
    }

}
