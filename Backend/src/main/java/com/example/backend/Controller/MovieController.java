package com.example.backend.Controller;

import java.util.List;

import com.example.backend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.Service.Movie.MovieService;
import com.example.backend.Model.Movie;

@RestController
@CrossOrigin("*")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/getAllMovies")
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieService.getAll();
		return movies;
	}

	@PostMapping("/addMovies")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		movieRepository.save(movie);
		return ResponseEntity.ok(movie);
	}
}

