package com.edusantanaw.bus.infra.repositories;

import com.edusantanaw.bus.domain.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaceRepository extends JpaRepository<Place, UUID> {
}
