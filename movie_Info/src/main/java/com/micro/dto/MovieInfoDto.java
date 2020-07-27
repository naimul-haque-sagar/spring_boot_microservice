package com.micro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieInfoDto {
    private String movieName;
    private Integer releaseYear;
    private String director;
    private String producer;
}