package com.dev.Zerphyis.estaciona.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataParking(String name,String EIN, String address, String phone, Integer carSpace, Integer motorcycleVacancies) {
}
