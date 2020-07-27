package com.controller.input;

import com.dto.MovieCastDto;
import com.service.MovieCastService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie_cast")
@AllArgsConstructor
public class MovieCastOperation {
    private final MovieCastService movieCastService;

    @RequestMapping("/post")
    public ResponseEntity postMovieCast(@RequestBody MovieCastDto movieCastDto){
        movieCastService.postMovieCastService(movieCastDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
