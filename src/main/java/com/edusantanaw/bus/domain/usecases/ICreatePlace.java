package com.edusantanaw.bus.domain.usecases;

import com.edusantanaw.bus.domain.entities.Place;
import com.edusantanaw.bus.validation.DTO.CreatePlaceDTO;

public interface ICreatePlace {
    Place execute(CreatePlaceDTO data);
}
