package com.dev.Zerphyis.estaciona.entity.parking;

import com.dev.Zerphyis.estaciona.Dtos.DataParking;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Tb_Estacionamento")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank

    private String name;
    @NotBlank

    private String EIN;
    @NotBlank

    private String address;
    @NotBlank

    private String phone;
    @NotNull

    private Integer carSpaces;
    @NotNull

    private Integer motorcycleVacancies;

    public  Parking(){

    }
    public Parking(DataParking data){
        this.name=data.name();
        this.EIN= data.EIN();
        this.address= data.address();
        this.phone= data.phone();
        this.motorcycleVacancies= data.motorcycleVacancies();
        this.carSpaces= data.carSpace();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEIN() {
        return EIN;
    }

    public void setEIN(String EIN) {
        this.EIN = EIN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCarSpaces() {
        return carSpaces;
    }

    public void setCarSpaces(Integer carSpaces) {
        this.carSpaces = carSpaces;
    }

    public Integer getMotorcycleVacancies() {
        return motorcycleVacancies;
    }

    public void setMotorcycleVacancies(Integer motorcycleVacancies) {
        this.motorcycleVacancies = motorcycleVacancies;
    }
}
