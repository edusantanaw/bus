package com.edusantanaw.bus.validation.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UpdatePlaceDTO extends CreatePlaceDTO {
    private  UUID id;
    public UpdatePlaceDTO(
            @NotNull UUID id,
            @NotBlank String name,
            @NotBlank String slug,
            @NotBlank String city,
            @NotBlank String state
    ) {
        super(name, slug, city, state);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
