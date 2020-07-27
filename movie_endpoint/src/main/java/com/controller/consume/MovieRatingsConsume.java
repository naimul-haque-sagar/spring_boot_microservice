package com.controller.consume;

import com.dto.MovieRatingsDto;
import com.service.MovieRatingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("movie-ratings-consume")
@AllArgsConstructor
public class MovieRatingsConsume {
    private final MovieRatingsService movieRatingsService;

    @RequestMapping("/get/{movieName}")
    public ResponseEntity<MovieRatingsDto> getMovieRatings(@PathVariable String movieName){
        MovieRatingsDto movieRatingsDto=movieRatingsService.getMovieRatingsServiceByMovieName(movieName);
        return ResponseEntity.status(HttpStatus.OK).body(movieRatingsDto);
    }

}
