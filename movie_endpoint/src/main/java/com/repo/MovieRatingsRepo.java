package com.repo;

import com.model.MovieRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRatingsRepo extends JpaRepository<MovieRatings,Integer> {
    Optional<MovieRatings> findByMovieName(String movieName);
}
