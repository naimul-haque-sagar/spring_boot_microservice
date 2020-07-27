package com.service;

import com.beanMapper.MovieInfoMapper;
import com.dto.MovieInfoDto;
import com.exception.CustomAppException;
import com.repo.MovieInfoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieInfoService {
    private final MovieInfoRepo movieInfoRepo;
    private final MovieInfoMapper movieInfoMapper;

    public void postMovieInfoService(MovieInfoDto movieInfoDto) {
        movieInfoRepo.save(movieInfoMapper.mapToModel(movieInfoDto));
    }

    public MovieInfoDto getMovieInfoByMovieName(String movieName) {
         return movieInfoMapper.mapToDto(movieInfoRepo.findByMovieName(movieName).orElseThrow(()-> new CustomAppException("No Data Found")));
    }
}
