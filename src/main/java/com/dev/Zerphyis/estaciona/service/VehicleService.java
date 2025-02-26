package com.dev.Zerphyis.estaciona.service;

import com.dev.Zerphyis.estaciona.Dtos.DataVehicle;
import com.dev.Zerphyis.estaciona.entity.vehicle.Vehicle;
import com.dev.Zerphyis.estaciona.repositorys.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository repository;

    @Transient
    public Vehicle registerVehicle(DataVehicle data) {
        if (data.plate().length() > 7) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A placa não pode ter mais de 7 caracteres.");
        }

        Optional<Vehicle> existingVehicle = repository.findByPlate(data.plate());
        if (existingVehicle.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um veículo com esta placa.");
        }

        var vehicle = new Vehicle(data);
        return repository.save(vehicle);
    }


    public List<Vehicle> listAll() {
        return repository.findAll();
    }

    public Vehicle getVehicleByPlate(String plate) {
        return repository.findByPlate(plate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado."));
    }

    @Transient
    public Vehicle updateVehicle(Long id, DataVehicle data) {
        Optional<Vehicle> updateVehicle = repository.findById(id);
        if (updateVehicle.isPresent()) {
            Vehicle newVehicule = updateVehicle.get();
            newVehicule.setMark(data.mark());
            newVehicule.setModel(data.model());
            newVehicule.setColor(data.color());
            newVehicule.setPlate(data.plate());
            newVehicule.setType(data.typeVehicle());
            return repository.save(newVehicule);
        } else {
            throw new RuntimeException("Veiculo não encontrado com o ID: " + id);
        }
    }

    @Transient
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Veiculo não encontrado no banco de dados");
        }
    }
}
