package com.task.citystorage.mapper;

import com.task.citystorage.dto.CityDto;
import com.task.citystorage.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityDto toDto(City city);
    City toEntity(CityDto dto);
}
