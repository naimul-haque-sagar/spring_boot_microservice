package com.beanMapper;

import com.dto.MovieRatingsDto;
import com.model.MovieRatings;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MovieRatingsMapper {
    MovieRatings mapToModel(MovieRatingsDto movieRatingsDto);

    MovieRatingsDto mapToDto(MovieRatings movieRatings);
}
