package com.edusantanaw.bus.infra.repositories;

import com.edusantanaw.bus.domain.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PlaceRepository extends JpaRepository<Place, UUID>{
    List<Place> findByNameContaining(String name);
}
