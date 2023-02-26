package com.edusantanaw.bus.infra.repositories;

import com.edusantanaw.bus.data.protocols.ISavePlaceRepository;
import com.edusantanaw.bus.domain.entities.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SavePlaceRepostitory implements ISavePlaceRepository {

    private final PlaceRepository repository;

    public Place save(Place data) {
        return repository.save(data);
    }
}
