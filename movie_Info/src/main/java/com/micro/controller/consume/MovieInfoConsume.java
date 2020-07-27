package com.micro.controller.consume;

import com.micro.dto.MovieInfoDto;
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
@RequestMapping("movie-info-consume")
@AllArgsConstructor
public class MovieInfoConsume {
    private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;

    static String MOVIE_INFO_CONSUME="http://movie-endpoint/movie-info-consume/get/";

    @GetMapping("/get/{movieName}")
    public ResponseEntity<MovieInfoDto> getMovieInfo(@PathVariable String movieName){
        MovieInfoDto movieInfoDto=restTemplate.getForObject(MOVIE_INFO_CONSUME+"/{movieName}",MovieInfoDto.class,movieName);
        return ResponseEntity.status(HttpStatus.OK).body(movieInfoDto);
    }
}
