package com.micro.service;

import com.micro.dto.MovieCastDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class MovieCast {
    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    static String MOVIE_CAST = "http://movie-cast/movie-cast-consume/get/";

    @HystrixCommand(fallbackMethod = "fallbackMovieCastDto")
    public MovieCastDto[] getMovieCastDto(String movieName) {
        return restTemplate.getForObject(MOVIE_CAST + "/{movieName}", MovieCastDto[].class, movieName);
    }

    public MovieCastDto[] fallbackMovieCastDto(String movieName) {
        return new MovieCastDto[]{
                   new MovieCastDto("fallback movie name", "fallback cast", 33, "male"),
                   new MovieCastDto("fallback movie name", "fallback cast", 33, "male"),
                   new MovieCastDto("fallback movie name", "fallback cast", 33, "male")
                };
    }

}