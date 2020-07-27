package com.controller.input;

import com.dto.MovieCastDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/movie-cast")
@AllArgsConstructor
public class MovieCastOperation {
    private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;

    static String POST_MOVIE_CAST="http://movie-endpoint/movie-cast/post/";

    @PostMapping("/post")
    public ResponseEntity postMovieCast(@RequestBody List<MovieCastDto> movieCastDtoList){
        restTemplate.postForObject(POST_MOVIE_CAST,movieCastDtoList,MovieCastDto.class);
        return new ResponseEntity(HttpStatus.OK);
    }
}
