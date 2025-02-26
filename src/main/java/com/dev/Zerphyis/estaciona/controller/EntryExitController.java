package com.dev.Zerphyis.estaciona.controller;

import com.dev.Zerphyis.estaciona.entity.entryExit.EntryExit;
import com.dev.Zerphyis.estaciona.entity.vehicle.TypeVehicle;
import com.dev.Zerphyis.estaciona.service.EntryExitService;
import com.dev.Zerphyis.estaciona.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class EntryExitController {
    @Autowired
    EntryExitService service;

    @PostMapping("/entrada")
    public ResponseEntity<EntryExit> entryVehicle(@RequestParam String personName,
                                                  @RequestParam String vehiclePlate,
                                                  @RequestParam TypeVehicle vehicleType,
                                                  @RequestParam Long parkingId) {
        try {
            EntryExit entry = service.registerEntry(personName, vehiclePlate, vehicleType, parkingId);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Registrar a saída de um veículo
    @PostMapping("/saida/{id}")
    public ResponseEntity<EntryExit> exitVehicle(@PathVariable Long id) {
        try {
            EntryExit exit = service.registerExit(id);
            return new ResponseEntity<>(exit, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    }


