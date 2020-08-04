package com.micro.service;

import com.micro.dto.MovieRatingsDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class MovieRatings {
    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    static String MOVIE_RATINGS = "http://movie-ratings/movie-ratings-consume/get/";

    @HystrixCommand(fallbackMethod = "fallbackMovieRatingsDto")
    public MovieRatingsDto getMovieRatingsDto(String movieName) {
        return restTemplate.getForObject(MOVIE_RATINGS + "/{movieName}", MovieRatingsDto.class, movieName);
    }

    private MovieRatingsDto fallbackMovieRatingsDto(String movieName) {
        return new MovieRatingsDto("Fallback name", 4);
    }

}