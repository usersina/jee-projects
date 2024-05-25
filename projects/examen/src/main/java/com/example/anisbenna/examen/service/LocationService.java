package com.example.anisbenna.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anisbenna.examen.models.Location;
import com.example.anisbenna.examen.repository.LocationRepository;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    /**
     * Trouver une location par son id
     * 
     * @param idLocation
     * @throws IllegalArgumentException si l'id de la location n'existe pas
     * @return objet Location
     */
    public Location trouverLocationParId(int idLocation) {
        return locationRepository.findById(idLocation).orElseThrow(
                () -> new IllegalArgumentException("Location avec l'id " + idLocation + " n'existe pas") //
        );
    }

    /**
     * Ajouter une location à la base de données
     *
     * @param location la location à ajouter
     * @return la location ajoutée
     */
    public Location demanderLocation(Location location) {
        return locationRepository.save(location);
    }

    /**
     * Supprimer une location par son id
     * 
     * @param idLocation
     */
    public void supprimerLocation(int idLocation) {
        locationRepository.deleteById(idLocation);
    }
}
