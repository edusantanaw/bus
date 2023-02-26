package com.edusantanaw.bus.data.protocols;

import com.edusantanaw.bus.domain.entities.Place;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ILoadPlaceRepository {
    Optional<Place> findById(UUID id);
    List<Place> findByNameContaining(String name);
    List<Place> findAll();
}
