package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCastDto {
    private String movieName;
    private String castName;
    private Integer age;
    private String gender;
}

