package com.example.anisbenna.examen.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehicule;

    private String marque;

    private int nombrePlaces;

    private int kilometrage;

    @OneToMany(mappedBy = "vehicule")
    private List<Location> locations;
}
