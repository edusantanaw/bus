package com.edusantanaw.bus.presentation.controllers;

import com.edusantanaw.bus.domain.usecases.IUpdatePlace;
import com.edusantanaw.bus.validation.DTO.UpdatePlaceDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/place/update")
@RequiredArgsConstructor
public class UpadatePlaceController {

    private final IUpdatePlace updatePlace;

    public ResponseEntity<?> handle(@RequestBody @Valid UpdatePlaceDTO data) {
        try {
            updatePlace.execute(data);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
