package com.dev.Zerphyis.estaciona.entity.vehicle;

import com.dev.Zerphyis.estaciona.Dtos.DataVehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_veiculos")
@EqualsAndHashCode(of = "id")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String mark;
    @NotBlank
    private  String model;
    @NotBlank
    private String color;
    @NotBlank
    private String plate;
    @NotNull
    private TypeVehicle type;

    public Vehicle(){

    }

    public Vehicle(DataVehicle data){
        this.mark=data.mark();
        this.model= data.model();
        this.plate= data.plate();
        this.color= data.color();
        this.type=data.type();
    }



    public Long getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public TypeVehicle getType() {
        return type;
    }

    public void setType(TypeVehicle type) {
        this.type = type;
    }
}
