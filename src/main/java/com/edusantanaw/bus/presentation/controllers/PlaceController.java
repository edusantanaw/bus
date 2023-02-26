package com.edusantanaw.bus.presentation.controllers;

import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.domain.usecases.ICreatePlace;
import com.edusantanaw.bus.domain.usecases.ILoadPlace;
import com.edusantanaw.bus.validation.DTO.CreatePlaceDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/place")
public class PlaceController {
    private final ICreatePlace createPlace;
    private ILoadPlace loadPlace;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody @Valid CreatePlaceDTO data
    ) {
        try {
            Place place = createPlace.execute(data);
            return new ResponseEntity<>(place, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

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
