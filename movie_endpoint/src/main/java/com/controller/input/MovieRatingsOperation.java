package com.controller.input;

import com.dto.MovieRatingsDto;
import com.service.MovieRatingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie_ratings")
@AllArgsConstructor
public class MovieRatingsOperation {
    private final MovieRatingsService movieRatingsService;

    @RequestMapping("/post")
    public ResponseEntity postMovieRatings(@RequestBody MovieRatingsDto movieRatingsDto){
        movieRatingsService.postMovieRatingsService(movieRatingsDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
