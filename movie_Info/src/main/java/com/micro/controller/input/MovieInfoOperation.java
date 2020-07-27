package com.micro.controller.input;

import com.micro.dto.MovieInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movie-info")
@AllArgsConstructor
public class MovieInfoOperation {
    private final WebClient.Builder webClientBuilder;
    private final RestTemplate restTemplate;

    static String POST_MOVIE_INFO="http://movie-endpoint/movie-info/post/";

    @PostMapping("/post")
    public Mono<MovieInfoDto> postMovieInfo(@RequestBody MovieInfoDto movieInfoDto){
        return webClientBuilder.build().post().uri(POST_MOVIE_INFO).body(BodyInserters
                .fromValue(movieInfoDto)).retrieve().bodyToMono(MovieInfoDto.class);
    }

    @PostMapping("/post1")
    public ResponseEntity postMovieInfo1(@RequestBody MovieInfoDto movieInfoDto){
        restTemplate.postForObject(POST_MOVIE_INFO,movieInfoDto,MovieInfoDto.class);
        return new ResponseEntity(HttpStatus.OK);
    }
}
