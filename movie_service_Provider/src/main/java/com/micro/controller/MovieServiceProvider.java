package com.micro.controller;

import com.micro.dto.*;
import com.micro.mapper.MovieCastMapper;
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
    private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;
    private final MovieCastMapper movieCastMapper;

    static String MOVIE_INFO="http://movie-info/movie-info-consume/get/";
    static String MOVIE_CAST="http://movie-cast/movie-cast-consume/get/";
    static String MOVIE_RATINGS="http://movie-ratings/movie-ratings-consume/get/";

    @GetMapping("/getAllInfo/{movieName}")
    @HystrixCommand(fallbackMethod = "getFallbackForAllInfo")
    public ResponseEntity<MovieInfoBundle> getAllInfo(@PathVariable String movieName){
        MovieInfoDto movieInfoDto=restTemplate.getForObject(MOVIE_INFO+"/{movieName}",MovieInfoDto.class,movieName);

        MovieCastDto[] movieCastDto=restTemplate.getForObject(MOVIE_CAST+"/{movieName}",MovieCastDto[].class,movieName);
        List<MovieCastDto> movieCastDtos=Arrays.asList(movieCastDto);

        MovieRatingsDto movieRatingsDto=restTemplate.getForObject(MOVIE_RATINGS+"/{movieName}",MovieRatingsDto.class,movieName);

        return ResponseEntity.status(HttpStatus.OK).
                body(new MovieInfoBundle(movieInfoDto.getReleaseYear(),movieInfoDto.getDirector(),movieInfoDto.getProducer()
       , movieCastDtos.stream().map(movieCastMapper::mapToDto).collect(Collectors.toList()),movieRatingsDto.getMovieRatings()));
    }

    public ResponseEntity<MovieInfoBundle> getFallbackForAllInfo(@PathVariable String movieName){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new MovieInfoBundle(2020,"director x","producer y",
                        Arrays.asList(new MovieCast_Dto("Fallback",44,"male"),
                                      new MovieCast_Dto("Fallback1",33,"male")), 4));
    }
}
