package com.example.anisbenna.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.anisbenna.examen.models.Vehicule;
import com.example.anisbenna.examen.service.VehiculeService;

@RestController("/vehicule")
public class VehiculeController {
    @Autowired
    public VehiculeService vehiculeService;

    @GetMapping("{marque}")
    public Vehicule trouverVehiculeParMarque(@PathVariable String marque) {
        return this.vehiculeService.trouverVehiculeParMarque(marque);
    }

    @DeleteMapping("{idVehicule}")
    public void supprimerVehicule(@PathVariable int idVehicule) {
        this.vehiculeService.supprimerVehicule(idVehicule);
    }

    @PutMapping("{id}")
    public Vehicule mettreAJourVehicule(@PathVariable int id, @RequestBody Vehicule newVehicule) {
        return this.vehiculeService.mettreAJourVehicule(id, newVehicule);
    }
}
