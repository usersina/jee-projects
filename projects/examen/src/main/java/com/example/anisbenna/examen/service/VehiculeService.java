package com.example.anisbenna.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anisbenna.examen.models.Vehicule;
import com.example.anisbenna.examen.repository.VehiculeRepository;

@Service
public class VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    /**
     * Trouver un vehicule par sa marque
     * 
     * @param marque la marque du vehicule
     * @return objet Vehicule
     */
    public Vehicule trouverVehiculeParMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }

    /**
     * Supprimer un vehicule par son id
     * 
     * @param idVehicule
     */
    public void supprimerVehicule(int idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    /**
     * Mettre à jour un vehicule
     *
     * @param idVehicule l'id du vehicule à mettre à jour
     * @param veh        le vehicule avec les nouvelles valeurs
     * @throws IllegalArgumentException si l'id du vehicule n'existe pas
     * @return le vehicule mis à jour
     */
    public Vehicule mettreAJourVehicule(int idVehicule, Vehicule veh) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElseThrow(
                () -> new IllegalArgumentException("Vehicule avec l'id " + idVehicule + " n'existe pas") //
        );
        vehicule.setMarque(veh.getMarque());
        vehicule.setNombrePlaces(veh.getNombrePlaces());
        vehicule.setKilometrage(veh.getKilometrage());
        vehicule.setLocations(veh.getLocations());
        return vehiculeRepository.save(vehicule);
    }
}
