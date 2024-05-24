package com.example.sprdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprdemo.models.Livre;
import com.example.sprdemo.service.LivreService;

@RestController("/livre")
public class LivreController {
    @Autowired
    public LivreService livreService;

    @PostMapping()
    public ResponseEntity<Livre> ajouter(@RequestBody Livre l) {
        Livre livre = this.livreService.ajouter(l);
        return ResponseEntity.status(201).body(livre);
    }
}
