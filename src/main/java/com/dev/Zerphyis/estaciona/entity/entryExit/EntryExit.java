package com.dev.Zerphyis.estaciona.entity.entryExit;

import com.dev.Zerphyis.estaciona.entity.vehicle.TypeVehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_entrada_saida")
public class EntryExit {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
         @NotBlank
        private String personName;
         @NotBlank

        private String vehiclePlate;
        private LocalDateTime entryTime;
        private LocalDateTime exitTime;

        @Enumerated(EnumType.STRING)
        private TypeVehicle vehicleType;
        private Long parkingId;

    public EntryExit(String personName, String vehiclePlate, LocalDateTime entryTime, TypeVehicle vehicleType, Long parkingId) {
        this.personName = personName;
        this.vehiclePlate = vehiclePlate;
        this.entryTime = entryTime;
        this.vehicleType = vehicleType;
        this.parkingId = parkingId;
    }

        public EntryExit() {
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

    public Long getParkingId() {
        return parkingId;
    }

    public void setParkingId(Long parkingId) {
        this.parkingId = parkingId;
    }

    public String getVehiclePlate() {
            return vehiclePlate;
        }

        public void setVehiclePlate(String vehiclePlate) {
            this.vehiclePlate = vehiclePlate;
        }

        public LocalDateTime getEntryTime() {
            return entryTime;
        }

        public void setEntryTime(LocalDateTime entryTime) {
            this.entryTime = entryTime;
        }

        public LocalDateTime getExitTime() {
            return exitTime;
        }

        public void setExitTime(LocalDateTime exitTime) {
            this.exitTime = exitTime;
        }

        public TypeVehicle getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(TypeVehicle vehicleType) {
            this.vehicleType = vehicleType;
        }
}
