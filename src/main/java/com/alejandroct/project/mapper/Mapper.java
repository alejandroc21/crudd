package com.alejandroct.project.mapper;

public interface Mapper <E, DTO>{
    E toEntity(DTO dto);

    DTO toDto(E e);
}
