package com.controller;

import com.dto.MovieCast;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movie_cast")
public class MovieCastOperation {
    @RequestMapping("/post")
    public ResponseEntity postMovieCast(@PathVariable List<MovieCast> movieCastList){
        //link to post
        return new ResponseEntity(HttpStatus.OK);
    }
}
