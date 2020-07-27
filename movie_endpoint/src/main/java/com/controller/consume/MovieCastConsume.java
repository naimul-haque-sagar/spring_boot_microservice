package com.controller.consume;

import com.dto.MovieCastDto;
import com.exception.CustomAppException;
import com.service.MovieCastService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movie-cast-consume")
@AllArgsConstructor
public class MovieCastConsume {
    private final MovieCastService movieCastService;

    @RequestMapping("/get/{movieName}")
    public ResponseEntity<List<MovieCastDto>> getMovieCast(@PathVariable String movieName){
        List<MovieCastDto> movieCastDtoList=movieCastService.getMovieCastByMovieName(movieName);
        return ResponseEntity.status(HttpStatus.OK).body(movieCastDtoList);
    }
}
