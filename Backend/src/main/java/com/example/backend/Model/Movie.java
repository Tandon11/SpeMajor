package com.example.backend.Model;

import javax.persistence.*;
import javax.websocket.OnError;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;


	private String movieName;
	private String genre;
	private String summary;
	private String review;

	@Column(columnDefinition = "Text")
	private String image;

	public Movie() {
		super();
	}

	public Movie(int movieId, String movieName, String genre, String summary, String review, String image) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
		this.summary = summary;
		this.review = review;
		this.image = image;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
