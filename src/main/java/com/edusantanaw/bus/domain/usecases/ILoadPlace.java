package com.edusantanaw.bus.domain.usecases;

import com.edusantanaw.bus.domain.entities.Place;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface ILoadPlace {
    Place loadById(UUID id);
    List<Place> loadPlacesByName(String name);
    List<Place> loadAllPlaces();
}
