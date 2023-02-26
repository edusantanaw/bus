package com.edusantanaw.bus.data.usecases;

import com.edusantanaw.bus.data.protocols.IPlaceRepository;
import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.domain.usecases.ICreatePlace;
import com.edusantanaw.bus.validation.DTO.CreatePlaceDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreatePlace implements ICreatePlace {
    private final IPlaceRepository placeRepository;
    public Place execute(CreatePlaceDTO data){
        Place newPlace =
                Place
                .builder()
                .name(data.getName())
                .slug(data.getSlug())
                .city(data.getCity())
                .state(data.getState())
                .build();
        placeRepository.save(newPlace);
        return  newPlace;
    }
}
