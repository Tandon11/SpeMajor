package com.example.backend.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BookingObject {

	private int id;
	private String email;
	private String movieName;
	private String locationName;
	private String theatreName;
	private String showTime;
	private int Count;

	public BookingObject() {

	}

	public BookingObject(String email, String movieName, String locationName, String theatreName, String showTime, int count) {
		this.email = email;
		this.movieName = movieName;
		this.locationName = locationName;
		this.theatreName = theatreName;
		this.showTime = showTime;
		Count = count;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}
}
