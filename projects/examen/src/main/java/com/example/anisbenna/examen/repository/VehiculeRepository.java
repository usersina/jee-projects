package com.example.anisbenna.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anisbenna.examen.models.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
    List<Vehicule> findByMarque(String marque);

    List<Vehicule> findByKilometrageLessThan(int kilometrage);

    List<Vehicule> findByNombrePlacesLessThanAndMarqueContaining(int nombrePlaces, String marque);
}
