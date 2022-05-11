package com.example.backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.Model.Movie;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
    @Query("Select movieName from Movie Where movieId = ?1")
    String findmovieName(int movieId);
}
