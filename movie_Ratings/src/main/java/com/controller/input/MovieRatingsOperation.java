package com.controller.input;

import com.dto.MovieRatingsDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("movie-ratings")
@AllArgsConstructor
public class MovieRatingsOperation {
    private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;

    static String POST_RATINGS_INFO="http://movie-endpoint/movie-ratings/post/";

    @RequestMapping("/post")
    public ResponseEntity postMovieRatings(@RequestBody MovieRatingsDto movieRatingsDto){
        restTemplate.postForObject(POST_RATINGS_INFO,movieRatingsDto,MovieRatingsDto.class);
        return new ResponseEntity(HttpStatus.OK);
    }
}
