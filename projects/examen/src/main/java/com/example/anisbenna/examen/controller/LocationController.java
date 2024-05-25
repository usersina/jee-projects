package com.example.anisbenna.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.anisbenna.examen.models.Location;
import com.example.anisbenna.examen.service.LocationService;

@RestController("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/")
    public Location demanderLocation(@RequestBody Location location) {
        return locationService.demanderLocation(location);
    }

    @GetMapping("/{idLocation}")
    public Location trouverLocationParId(@PathVariable int idLocation) {
        return locationService.trouverLocationParId(idLocation);
    }
}
