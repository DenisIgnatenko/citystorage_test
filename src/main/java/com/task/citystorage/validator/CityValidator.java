package com.task.citystorage.validator;

import com.task.citystorage.dto.CityDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CityValidator {
    public void validate(CityDto dto) {
        if (!StringUtils.hasText(dto.getName())) {
            throw new IllegalArgumentException("City name must not be empty");
        }

        if (!StringUtils.hasText(dto.getCountry())) {
            throw new IllegalArgumentException("Country must not be empty");
        }

        if (dto.getPopulation() != null && dto.getPopulation() < 0) {
            throw new IllegalArgumentException("Population must not be negative");
        }
    }
}