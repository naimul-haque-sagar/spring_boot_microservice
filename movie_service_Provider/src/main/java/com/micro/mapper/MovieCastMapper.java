package com.micro.mapper;

import com.micro.dto.MovieCastDto;
import com.micro.dto.MovieCast_Dto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieCastMapper {
    MovieCast_Dto mapToDto(MovieCastDto movieCastDto);
}
