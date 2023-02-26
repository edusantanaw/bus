package com.edusantanaw.bus.presentation.controllers;

import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.domain.usecases.ICreatePlace;
import com.edusantanaw.bus.infra.repositories.PlaceRepository;
import com.edusantanaw.bus.validation.DTO.CreatePlaceDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/place")
public class PlaceController {
    private final ICreatePlace createPlace;


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
}
