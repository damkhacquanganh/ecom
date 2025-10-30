package com.eco.cinemamanagementbackend.mapper;

import java.util.List;

public interface BaseMapper<Entity, Dto> {
    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

    List<Dto> toDtoList(List<Entity> entities);
    List<Entity> toEntityList(List<Dto> dtos);
}
