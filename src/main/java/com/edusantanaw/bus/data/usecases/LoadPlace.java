package com.edusantanaw.bus.data.usecases;

import com.edusantanaw.bus.data.protocols.ILoadPlaceRepository;
import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.domain.usecases.ILoadPlace;
import lombok.RequiredArgsConstructor;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class LoadPlace implements ILoadPlace {

    private final ILoadPlaceRepository placeRepository;

    public Place loadById(UUID id) {
        return placeRepository
                .findById(id)
                .orElseThrow(() -> new Error("Place not found!"));
    }

    public List<Place> loadPlacesByName(String name) {
        return placeRepository.findByPlaceNameContaining(name);
    }

    public List<Place> loadAllPlaces(Pageable page) {
        return placeRepository.findAll(page);
    }
}
