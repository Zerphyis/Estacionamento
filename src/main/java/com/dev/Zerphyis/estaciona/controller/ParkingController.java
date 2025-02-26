package com.dev.Zerphyis.estaciona.controller;

import com.dev.Zerphyis.estaciona.Dtos.DataParking;
import com.dev.Zerphyis.estaciona.entity.parking.Parking;
import com.dev.Zerphyis.estaciona.service.ParkingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estacionamento")
public class ParkingController {

    @Autowired
    ParkingService service;

    @PostMapping
    public ResponseEntity<Parking> createParking(@Valid @RequestBody DataParking dataParking) {
        Parking createdParking = service.createParking(dataParking);
        return new ResponseEntity<>(createdParking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Parking>> getAllParkings() {
        List<Parking> parkings = service.getAllParkings();
        return new ResponseEntity<>(parkings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parking> getParkingById(@PathVariable Long id) {
        Optional<Parking> parking = service.getParkingById(id);
        return parking.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parking> updateParking(@PathVariable Long id, @Valid @RequestBody DataParking dataParking) {
        try {
            Parking updatedParking = service.updateParking(id, dataParking);
            return new ResponseEntity<>(updatedParking, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParking(@PathVariable Long id) {
        try {
            service.deleteParking(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
