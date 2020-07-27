package com.beanMapper;

import com.dto.MovieInfoDto;
import com.model.MovieInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieInfoMapper {
    MovieInfo mapToModel(MovieInfoDto movieInfoDto);

    MovieInfoDto mapToDto(MovieInfo movieInfo);
}
