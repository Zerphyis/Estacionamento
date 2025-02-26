package com.dev.Zerphyis.estaciona.service;

import com.dev.Zerphyis.estaciona.entity.entryExit.EntryExit;
import com.dev.Zerphyis.estaciona.entity.parking.Parking;
import com.dev.Zerphyis.estaciona.entity.vehicle.TypeVehicle;
import com.dev.Zerphyis.estaciona.repositorys.EntryExitRepository;
import com.dev.Zerphyis.estaciona.repositorys.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EntryExitService {
        @Autowired
        ParkingRepository parkingRepository;
        @Autowired
        EntryExitRepository repository;

        public EntryExit registerEntry(String personName, String vehiclePlate, TypeVehicle vehicleType, Long parkingId) {
            // Buscar o estacionamento pelo ID passado como parâmetro
            Parking parking = parkingRepository.findById(parkingId)
                    .orElseThrow(() -> new RuntimeException("Parking not found"));

            // Verificar se há vagas disponíveis de acordo com o tipo de veículo
            if ((vehicleType == TypeVehicle.CAR && parking.getCarSpaces() <= 0) ||
                    (vehicleType == TypeVehicle.MOTORCYCLE && parking.getMotorcycleVacancies() <= 0)) {
                throw new RuntimeException("No available spots for this vehicle type");
            }

            // Registrar a entrada do veículo
            EntryExit entry = new EntryExit(personName, vehiclePlate, LocalDateTime.now(), vehicleType, parkingId);
            return repository.save(entry);
        }

        public EntryExit registerExit(Long id) {
            // Buscar o registro da entrada do veículo pelo ID
            EntryExit entryExit = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Parking entry not found"));

            // Atualizar o horário de saída
            entryExit.setExitTime(LocalDateTime.now());

            // Buscar o estacionamento associado ao veículo
            Parking parking = parkingRepository.findById(entryExit.getParkingId())
                    .orElseThrow(() -> new RuntimeException("Parking not found"));

            // Atualizar as vagas do estacionamento conforme o tipo do veículo
            if (entryExit.getVehicleType() == TypeVehicle.CAR) {
                parking.setCarSpaces(parking.getCarSpaces() + 1); // Incrementar vaga de carro
            } else if (entryExit.getVehicleType() == TypeVehicle.MOTORCYCLE) {
                parking.setMotorcycleVacancies(parking.getMotorcycleVacancies() + 1); // Incrementar vaga de moto
            }

            // Salvar as mudanças no estacionamento
            parkingRepository.save(parking);

            // Salvar a saída do veículo no registro
            return repository.save(entryExit);
        }
    }





