package com.edusantanaw.bus.data.usecases;

import com.edusantanaw.bus.data.protocols.ILoadPlaceRepository;
import com.edusantanaw.bus.data.protocols.ISavePlaceRepository;
import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.domain.usecases.IUpdatePlace;
import com.edusantanaw.bus.validation.DTO.UpdatePlaceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class UpdatePlace implements IUpdatePlace {
    private final ISavePlaceRepository placeRepository;
    private final ILoadPlaceRepository loadPlaceRepository;

    public void execute(UpdatePlaceDTO data) {
        Place place =
                loadPlaceRepository
                        .findById(data.getId())
                        .orElseThrow(() -> new Error("Place not exists!"));
        place.setName(data.getName());
        place.setSlug(data.getSlug());
        place.setCity(data.getCity());
        place.setState(data.getState());
        place.setUpdatedAt(currentDate());
        placeRepository.save(place);
    }
    private Date currentDate(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
