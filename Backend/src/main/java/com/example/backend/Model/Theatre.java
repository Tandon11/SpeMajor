package com.example.backend.Model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theatre {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int theatreId;

	private int locationId;
	private String theatreName;
	private int MovieID;

	public Theatre() {
		super();
	}

	public Theatre(int theatreId, int locationId, String theatreName, int movieID) {
		this.theatreId = theatreId;
		this.locationId = locationId;
		this.theatreName = theatreName;
		MovieID = movieID;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public int getMovieID() {
		return MovieID;
	}

	public void setMovieID(int movieID) {
		MovieID = movieID;
	}
}
