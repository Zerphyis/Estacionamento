package com.dev.Zerphyis.estaciona.controller;

import com.dev.Zerphyis.estaciona.Dtos.DataVehicle;
import com.dev.Zerphyis.estaciona.entity.vehicle.Vehicle;
import com.dev.Zerphyis.estaciona.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/veiculos")
public class VehicleController {
    @Autowired
    VehicleService service;

    @PostMapping
    public ResponseEntity<Vehicle> registerVehicle(@RequestBody DataVehicle data) {
        Vehicle vehicle = service.registerVehicle(data);
        return ResponseEntity.status(201).body(vehicle);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> listAllVehicles() {
        List<Vehicle> vehicles = service.listAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{plate}")
    public ResponseEntity<Vehicle> getVehicleByPlate(@PathVariable String plate) {
        Vehicle vehicle = service.getVehicleByPlate(plate);
        return ResponseEntity.ok(vehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody DataVehicle data) {
        Vehicle updatedVehicle = service.updateVehicle(id, data);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


