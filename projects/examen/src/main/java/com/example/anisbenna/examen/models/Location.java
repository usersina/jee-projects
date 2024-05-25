package com.example.anisbenna.examen.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLocation;

    private Date dateDebutLocation;

    private Date dateFinLocation;

    @ManyToOne
    @JoinColumn(name = "idVehicule")
    private Vehicule vehicule;
}
