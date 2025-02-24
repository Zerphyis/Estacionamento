package com.dev.Zerphyis.estaciona.Dtos;

import com.dev.Zerphyis.estaciona.entity.vehicle.TypeVehicle;

public record DataVehicle(String mark, String model, String color, String plate, TypeVehicle type) {
}
