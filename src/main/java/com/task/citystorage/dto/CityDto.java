package com.task.citystorage.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private Long id;

    @NotBlank(message = "City name must not be blank")
    @Size(max = 100, message = "City must not exceed 100 characters")
    private String name;

    @NotBlank
    @Size(max = 255)
    private String country;

    @Max(1_000_000_000)
    private Long population;
}
