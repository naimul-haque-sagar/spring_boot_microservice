package com.repo;

import com.model.MovieCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCastRepo extends JpaRepository<MovieCast,Integer> {
    Optional<List<MovieCast>> findByMovieName(String movieName);
}
