package com.task.citystorage.controller;

import com.task.citystorage.dto.CityDto;
import com.task.citystorage.mapper.CityMapper;
import com.task.citystorage.service.CityService;
import com.task.citystorage.validator.CityValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getById(id));
    }

}
