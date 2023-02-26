package com.edusantanaw.bus.domain.usecases;

import com.edusantanaw.bus.validation.DTO.UpdatePlaceDTO;

public interface IUpdatePlace {
    void execute(UpdatePlaceDTO data);
}
