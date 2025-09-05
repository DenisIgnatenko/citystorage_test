package com.task.citystorage.service;

import com.task.citystorage.dto.CityDto;
import com.task.citystorage.entity.City;
import com.task.citystorage.exception.CityNotFoundException;
import com.task.citystorage.mapper.CityMapper;
import com.task.citystorage.repository.CityRepository;
import com.task.citystorage.validator.CityValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final CityValidator cityValidator;

    @Transactional
    public CityDto create(CityDto dto) {
        log.info("Creating city with name: {}", dto.getName());
        cityValidator.validate(dto);
        City city = cityMapper.toEntity(dto);
        return cityMapper.toDto(cityRepository.save(city));
    }

    public List<CityDto> getAll() {
        log.info("Fetching all cities");
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::toDto)
                .toList();
    }

    public CityDto getById(Long id) {
        log.info("Fetching city by id: {}", id);
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found with id " + id));
        return cityMapper.toDto(city);
    }

    @Transactional
    public void delete(Long id) {
        log.warn("Deleting city with id: {}", id);
        cityRepository.deleteById(id);
    }
}
