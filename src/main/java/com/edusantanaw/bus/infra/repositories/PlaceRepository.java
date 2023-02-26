package com.edusantanaw.bus.infra.repositories;

import com.edusantanaw.bus.domain.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface PlaceRepository extends JpaRepository<Place, UUID>{
    List<Place> findByPlaceNameContaining(String name);
    List<Place> findAll(Pageable page);
}
