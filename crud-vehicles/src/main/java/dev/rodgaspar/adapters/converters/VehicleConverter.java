package dev.rodgaspar.adapters.converters;

import java.util.List;
import java.util.stream.Collectors;

import dev.rodgaspar.adapters.dto.VehicleDto;
import dev.rodgaspar.core.model.VehicleModel;
import dev.rodgaspar.entity.Vehicle;

public class VehicleConverter {

    public static List<VehicleDto> toDtoList(List<VehicleModel> carros) {
        return carros.stream()
                .map(VehicleConverter::toDto)
                .collect(Collectors.toList());
    }

    public static VehicleDto toDto(VehicleModel vehicle) {
        return VehicleDto.builder()
                .id(vehicle.getId())
                .model(vehicle.getModel())
                .type(vehicle.getType())
                .year(vehicle.getYear())
                .manufacturer(vehicle.getManufacturer())
                .build();
    }

    public static List<VehicleModel> toModelList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(VehicleConverter::toModel)
                .collect(Collectors.toList());
    }

    public static VehicleModel toModel(VehicleDto vehicleDto) {
        return VehicleModel.builder()
                .id(vehicleDto.getId())
                .model(vehicleDto.getModel())
                .type(vehicleDto.getType())
                .year(vehicleDto.getYear())
                .manufacturer(vehicleDto.getManufacturer())
                .build();
    }

    public static VehicleModel toModel(Vehicle vehicle) {
        return VehicleModel.builder()
                .id(vehicle.id)
                .model(vehicle.getModel())
                .type(vehicle.getType())
                .year(vehicle.getYear())
                .manufacturer(vehicle.getManufacturer())
                .build();
    }

}
