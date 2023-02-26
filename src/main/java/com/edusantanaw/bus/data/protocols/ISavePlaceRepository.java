package com.edusantanaw.bus.data.protocols;

import com.edusantanaw.bus.domain.entities.Place;

public interface ISavePlaceRepository {
    Place save(Place data);
}
