package com.service;

import com.beanMapper.MovieRatingsMapper;
import com.dto.MovieRatingsDto;
import com.exception.CustomAppException;
import com.model.MovieRatings;
import com.repo.MovieRatingsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieRatingsService {
    private final MovieRatingsMapper movieRatingsMapper;
    private final MovieRatingsRepo movieRatingsRepo;

    public void postMovieRatingsService(MovieRatingsDto movieRatingsDto) {
        movieRatingsRepo.save(movieRatingsMapper.mapToModel(movieRatingsDto));
    }

    public MovieRatingsDto getMovieRatingsServiceByMovieName(String movieName) {
        return movieRatingsMapper.mapToDto(movieRatingsRepo.findByMovieName(movieName).orElseThrow(()-> new CustomAppException("No Data Found")));
    }
}
