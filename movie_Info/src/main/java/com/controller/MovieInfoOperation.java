package com.controller;

import com.dto.MovieInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie_info")
public class MovieInfoOperation {
    @RequestMapping("/post")
    public ResponseEntity postMovieInfo(@PathVariable MovieInfo movieInfo){
        //link to post
        return new ResponseEntity(HttpStatus.OK);
    }
}
