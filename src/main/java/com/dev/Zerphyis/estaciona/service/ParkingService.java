package com.dev.Zerphyis.estaciona.service;

import com.dev.Zerphyis.estaciona.Dtos.DataParking;
import com.dev.Zerphyis.estaciona.entity.parking.Parking;
import com.dev.Zerphyis.estaciona.repositorys.ParkingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ParkingService {
    @Autowired
    ParkingRepository repository;

    @Transactional
    public Parking createParking(DataParking data) {
        Parking parking = new Parking(data);
        return repository.save(parking);
    }


    public List<Parking> getAllParkings() {
        return repository.findAll();
    }

    public Optional<Parking> getParkingById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Parking updateParking(Long id, DataParking data) {
        Optional<Parking> existingParking = repository.findById(id);

        if (existingParking.isPresent()) {
            Parking parking = existingParking.get();
            parking.setName(data.name());
            parking.setEIN(data.EIN());
            parking.setAddress(data.address());
            parking.setPhone(data.phone());
            parking.setCarSpaces(data.carSpace());
            parking.setMotorcycleVacancies(data.motorcycleVacancies());
            return repository.save(parking);
        } else {
            throw new RuntimeException("Estacionamento não encontrado com ID: " + id);
        }
    }

    @Transactional
    public void deleteParking(Long id) {
        Optional<Parking> existingParking = repository.findById(id);

        if (existingParking.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Estacionamento não encontrado com ID: " + id);
        }
    }
}
