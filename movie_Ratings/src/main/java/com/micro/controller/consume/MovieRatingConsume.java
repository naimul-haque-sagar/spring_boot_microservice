package com.micro.controller.consume;

import com.micro.dto.MovieRatingsDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("movie-ratings-consume")
@AllArgsConstructor
public class MovieRatingConsume {
    private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;

    static String MOVIE_RATINGS_CONSUME="http://movie-endpoint/movie-ratings-consume/get/";

    @GetMapping("/get/{movieName}")
    public ResponseEntity<MovieRatingsDto> getMovieRatings(@PathVariable String movieName){
        return ResponseEntity.status(HttpStatus.OK)
                .body(restTemplate.getForObject(MOVIE_RATINGS_CONSUME+"/{movieName}",MovieRatingsDto.class,movieName));
    }
}
