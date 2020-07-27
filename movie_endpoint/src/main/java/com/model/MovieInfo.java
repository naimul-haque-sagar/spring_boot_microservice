package com.model;

import com.google.inject.internal.cglib.core.$Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "movie_info")
@NoArgsConstructor
public class MovieInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieInfoId;
    private String movieName;
    private Integer releaseYear;
    private String director;
    private String producer;
}
