package com.micro.service;

import com.micro.dto.MovieInfoDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class MovieInfo {
    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    static String MOVIE_INFO="http://movie-info/movie-info-consume/get/";

    @HystrixCommand(fallbackMethod = "fallbackMovieInfoDto")
    public MovieInfoDto getMovieInfoDto(String movieName) {
        return restTemplate.getForObject(MOVIE_INFO + "/{movieName}", MovieInfoDto.class, movieName);
    }

    public MovieInfoDto fallbackMovieInfoDto(String movieName) {
        return new MovieInfoDto("fallback movie",2020,"g","h");
    }
}
