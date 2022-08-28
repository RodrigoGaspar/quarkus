package dev.rodgaspar.core.biz;

import javax.enterprise.context.ApplicationScoped;

import dev.rodgaspar.core.model.CarroModel;
import dev.rodgaspar.core.ports.CarroBusinessPort;

@ApplicationScoped
public class CarroBusiness implements CarroBusinessPort {

    @Override
    public CarroModel listAll() {
        return CarroModel.builder()
                .modelo("Renegade")
                .ano(2019)
                .fabricante("Jeep")
                .build();
    }

}
