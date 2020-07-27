package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie_ratings")
public class MovieRatingsOperation {
    @RequestMapping("/post")
    public ResponseEntity postMovieRatings(@PathVariable MovieRatingsOperation movieRatingsOperation){
        //link to post
        return new ResponseEntity(HttpStatus.OK);
    }
}
