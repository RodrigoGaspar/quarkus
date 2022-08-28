package dev.rodgaspar.adapters.converters;

import javax.enterprise.context.ApplicationScoped;

import dev.rodgaspar.adapters.dto.CarrosDto;
import dev.rodgaspar.core.model.CarroModel;

public class CarrosConverter {

    public static CarrosDto modelToDto(CarroModel carroModel) {
        return CarrosDto.builder()
                .modelo(carroModel.getModelo())
                .ano(carroModel.getAno())
                .fabricante(carroModel.getFabricante())
                .build();
    }

}
