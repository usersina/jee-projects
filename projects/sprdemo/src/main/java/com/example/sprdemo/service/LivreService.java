package com.example.sprdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprdemo.models.Livre;
import com.example.sprdemo.repository.LivreRepository;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;

    public Livre ajouter(Livre livre) {
        return this.livreRepository.save(livre);
    }

    public List<Livre> chercher() {
        return this.livreRepository.findAll();
    }

    public List<Livre> chercherTitreContenant(String word) {
        return this.livreRepository.findByTitreContaining(word);
    }

    public void supprimer(Integer id) {
        this.livreRepository.deleteById(id);
    }
}
