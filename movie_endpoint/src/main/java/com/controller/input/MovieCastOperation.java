package com.controller.input;

import com.dto.MovieCastDto;
import com.service.MovieCastService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movie-cast")
@AllArgsConstructor
public class MovieCastOperation {
    private final MovieCastService movieCastService;

    @PostMapping("/post")
    public ResponseEntity postMovieCast(@RequestBody List<MovieCastDto> movieCastDto){
        movieCastService.postMovieCastService(movieCastDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
