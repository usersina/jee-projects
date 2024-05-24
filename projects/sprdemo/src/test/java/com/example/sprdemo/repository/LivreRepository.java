package com.example.sprdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sprdemo.models.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {
    List<Livre> findByTitre(String titre);

    List<Livre> findByTitreContaining(String word);
}
