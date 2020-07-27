package com.micro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCast_Dto {
    private String castName;
    private Integer age;
    private String gender;
}
