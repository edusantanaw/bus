package com.edusantanaw.bus.infra.repositories;

import com.edusantanaw.bus.data.protocols.ILoadPlaceRepository;
import com.edusantanaw.bus.domain.entities.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LoadPlaceRepository implements ILoadPlaceRepository {

    private final PlaceRepository repository;

    public Optional<Place> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Place> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Place> findAll() {
        return repository.findAll();
    }
}
