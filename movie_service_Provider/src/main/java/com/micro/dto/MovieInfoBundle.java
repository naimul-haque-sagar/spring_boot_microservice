package com.micro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieInfoBundle {
    private Integer releaseYear;
    private String director;
    private String producer;
    private List<MovieCast_Dto> movieCast_dtoList;
    private Integer movieRatings;
}
