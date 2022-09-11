package dev.rodgaspar.core.biz;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.core.ports.VehicleBusinessPort;
import dev.rodgaspar.core.ports.VehicleEntityPort;

@ApplicationScoped
public class VehicleBusiness implements VehicleBusinessPort {

    @Inject
    VehicleEntityPort vehicleEntity;

    @Override
    public List<VehicleModel> listAll() {
        return vehicleEntity.findAll();
    }

    @Override
    public VehicleModel update(VehicleModel vehicleModel) {
        return vehicleEntity.update(vehicleModel);
        
    }

    @Override
    public VehicleModel create(VehicleModel vehicleModel) {
        return vehicleEntity.save(vehicleModel);
    }

}
