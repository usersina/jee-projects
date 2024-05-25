package com.example.anisbenna.examen.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anisbenna.examen.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    public List<Location> findByDateDebutLocationBetween(Date startDate, Date endDate);
}
