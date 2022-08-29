package dev.rodgaspar.adapters.converters;

import java.util.List;
import java.util.stream.Collectors;

import dev.rodgaspar.adapters.dto.VehicleDto;
import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.domain.Vehicle;

public class VehicleConverter {

    public static List<VehicleDto> modelToDto(List<Vehicle> carros) {
        return carros.stream()
                .map(VehicleConverter::vehicleModelToDto)
                .collect(Collectors.toList());
    }

    private static VehicleDto vehicleModelToDto(Vehicle vehicleModel) {
        return VehicleDto.builder()
                .modelo(vehicleModel.getModelo())
                .ano(vehicleModel.getAno())
                .fabricante(vehicleModel.getFabricante())
                .build();
    }

}
