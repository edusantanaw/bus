package com.edusantanaw.bus.data.protocols;

import com.edusantanaw.bus.domain.entities.Place;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ILoadPlaceRepository {
    Optional<Place> findById(UUID id);
    List<Place> findByPlaceNameContaining(String name);
    List<Place> findAll(Pageable page);
}
