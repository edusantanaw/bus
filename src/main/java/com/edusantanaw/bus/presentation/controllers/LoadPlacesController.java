package com.edusantanaw.bus.presentation.controllers;

import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.domain.usecases.ILoadPlace;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/place")
public class LoadPlacesController {
    private ILoadPlace loadPlace;
    @GetMapping
    public ResponseEntity<List<Place>> loadAll(Pageable page) {
        List<Place> places = loadPlace.loadAllPlaces(page);
        return ResponseEntity.ok(places);
    }

    @GetMapping
    public ResponseEntity<List<Place>> loadByName(@Param("name") String name) {
        List<Place> places = loadPlace.loadPlacesByName(name);
        return ResponseEntity.ok(places);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> loadById(@RequestParam UUID id) {
        try {
            Place place = loadPlace.loadById(id);
            return ResponseEntity.ok(place);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
