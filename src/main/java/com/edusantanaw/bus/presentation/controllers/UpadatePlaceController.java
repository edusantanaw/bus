package com.edusantanaw.bus.presentation.controllers;

import com.edusantanaw.bus.validation.DTO.UpdatePlaceDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/place/update")
@RequiredArgsConstructor
public class UpadatePlaceController {

    public void handle(@RequestBody @Valid UpdatePlaceDTO data){

    }
}
