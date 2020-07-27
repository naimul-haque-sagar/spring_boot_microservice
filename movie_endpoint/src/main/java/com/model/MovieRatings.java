package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "movie_ratings")
public class MovieRatings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieRatingsId;
    private String movieName;
    private Integer movieRatings;
}
