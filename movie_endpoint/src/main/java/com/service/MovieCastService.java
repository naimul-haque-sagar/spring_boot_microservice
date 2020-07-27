package com.service;

import com.beanMapper.MovieCastMapper;
import com.dto.MovieCastDto;
import com.exception.CustomAppException;
import com.model.MovieCast;
import com.repo.MovieCastRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieCastService {
    private final MovieCastRepo movieCastRepo;
    private final MovieCastMapper movieCastMapper;

    public void postMovieCastService(MovieCastDto movieCastDto) {
        movieCastRepo.save(movieCastMapper.mapToModel(movieCastDto));
    }

    public List<MovieCastDto> getMovieCastByMovieName(String movieName) {
         List<MovieCast> movieCastDtoList=movieCastRepo.findByMovieName(movieName).orElseThrow(()-> new CustomAppException("No Data Found"));
         return movieCastDtoList.stream().map(movieCastMapper::mapToDto).collect(Collectors.toList());
    }
}
