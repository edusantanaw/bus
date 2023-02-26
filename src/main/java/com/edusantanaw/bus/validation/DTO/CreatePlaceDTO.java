package com.edusantanaw.bus.validation.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePlaceDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String slug;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
}
