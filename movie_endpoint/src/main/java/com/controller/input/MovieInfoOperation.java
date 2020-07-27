package com.controller.input;

import com.dto.MovieInfoDto;
import com.model.MovieInfo;
import com.service.MovieInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie_info")
@AllArgsConstructor
public class MovieInfoOperation {
    private final MovieInfoService movieInfoService;

    @RequestMapping("/post")
    public ResponseEntity postMovieInfo(@RequestBody MovieInfoDto movieInfoDto){
        movieInfoService.postMovieInfoService(movieInfoDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
