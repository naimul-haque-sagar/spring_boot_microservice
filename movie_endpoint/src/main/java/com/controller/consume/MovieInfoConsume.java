package com.controller.consume;

import com.dto.MovieInfoDto;
import com.model.MovieInfo;
import com.service.MovieInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("movie_info_consume")
@AllArgsConstructor
public class MovieInfoConsume {
    private final MovieInfoService movieInfoService;

    @RequestMapping("get/{movieName}")
    public ResponseEntity<MovieInfoDto> getMovieInfo(@PathVariable String movieName){
        return ResponseEntity.status(HttpStatus.OK).body(movieInfoService.getMovieInfoByMovieName(movieName));
    }
}
