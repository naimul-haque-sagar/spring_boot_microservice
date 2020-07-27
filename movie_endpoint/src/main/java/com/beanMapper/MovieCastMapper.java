package com.beanMapper;

import com.dto.MovieCastDto;
import com.model.MovieCast;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieCastMapper {
    MovieCast mapToModel(MovieCastDto movieCastDto);

    MovieCastDto mapToDto(MovieCast movieCast);
}
