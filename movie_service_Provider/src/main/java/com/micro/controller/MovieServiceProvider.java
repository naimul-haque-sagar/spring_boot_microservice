package com.micro.controller;

import com.micro.dto.*;
import com.micro.mapper.MovieCastMapper;
import com.micro.service.MovieCast;
import com.micro.service.MovieInfo;
import com.micro.service.MovieRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("movie-service-provider")
@AllArgsConstructor
public class MovieServiceProvider {
    private final MovieCastMapper movieCastMapper;
    private final MovieRatings movieRatings;
    private final MovieCast movieCast;
    private final MovieInfo movieInfo;


    @GetMapping("/getAllInfo/{movieName}")
    public ResponseEntity<MovieInfoBundle> getAllInfo(@PathVariable String movieName){
        MovieInfoDto movieInfoDto= movieInfo.getMovieInfoDto(movieName);

        MovieCastDto[] movieCastDto= movieCast.getMovieCastDto(movieName);
        List<MovieCastDto> movieCastDtos=Arrays.asList(movieCastDto);

        MovieRatingsDto movieRatingsDto= movieRatings.getMovieRatingsDto(movieName);

        return ResponseEntity.status(HttpStatus.OK).
                body(new MovieInfoBundle(movieInfoDto.getReleaseYear(),movieInfoDto.getDirector(),movieInfoDto.getProducer()
       , movieCastDtos.stream().map(movieCastMapper::mapToDto).collect(Collectors.toList()),movieRatingsDto.getMovieRatings()));
    }

}
