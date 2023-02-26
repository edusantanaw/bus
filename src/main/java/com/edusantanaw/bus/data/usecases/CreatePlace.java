package com.edusantanaw.bus.data.usecases;

import com.edusantanaw.bus.data.protocols.ISavePlaceRepository;
import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.domain.usecases.ICreatePlace;
import com.edusantanaw.bus.validation.DTO.CreatePlaceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePlace implements ICreatePlace {
    private final ISavePlaceRepository placeRepository;
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
