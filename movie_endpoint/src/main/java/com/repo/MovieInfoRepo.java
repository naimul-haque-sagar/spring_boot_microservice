package com.repo;

import com.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieInfoRepo extends JpaRepository<MovieInfo,Integer> {
    Optional<MovieInfo> findByMovieName(String movieName);
}
