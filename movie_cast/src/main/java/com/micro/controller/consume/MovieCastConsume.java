package com.micro.controller.consume;

import com.micro.dto.MovieCastDto;
import lombok.AllArgsConstructor;
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

@RestController
@RequestMapping("movie-cast-consume")
@AllArgsConstructor
public class MovieCastConsume {
    private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;

    static String MOVIE_CAST_CONSUME="http://movie-endpoint/movie-cast-consume/get/";

    @GetMapping("get/{movieName}")
    public ResponseEntity<List<MovieCastDto>> getMovieCast(@PathVariable String movieName){
        MovieCastDto[] movieCastDtoList=restTemplate.getForObject(MOVIE_CAST_CONSUME+"/{movieName}",MovieCastDto[].class,movieName);
        return ResponseEntity.status(HttpStatus.OK).body(movieCastDtoList.length!=0? Arrays.asList(movieCastDtoList):Collections.emptyList());
    }

}
