package com.example.apiprueba.modelo.entidades;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Sneaker {
    @Id
    @GeneratedValue
    private Integer sneakerId;
    private String brand;
    private String model;
    private Date releaseDate;
    private String mainColor;
    private String sku;

}
