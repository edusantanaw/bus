package com.edusantanaw.bus.presentation.controllers;

import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.domain.usecases.ILoadPlace;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/place/load")
public class LoadPlacesController {
    private final ILoadPlace loadPlace;
    @GetMapping
    public ResponseEntity<List<Place>> loadAll() {
        List<Place> places = loadPlace.loadAllPlaces();
        return ResponseEntity.ok(places);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Place>> loadByName(@PathVariable String name) {
        List<Place> places = loadPlace.loadPlacesByName(name);
        return ResponseEntity.ok(places);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> loadById(@PathVariable UUID id) {
        try {
            Place place = loadPlace.loadById(id);
            return ResponseEntity.ok(place);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
