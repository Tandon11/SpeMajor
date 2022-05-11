package com.example.backend.Model;

import javax.persistence.*;
import javax.websocket.OnError;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private String email;
	private int movieId;
	private int locationId;
	private int theatreId;
	private int showId;
	private String seatId;
	private int count;
	private int amount;
    
	public Booking() {

	}

	public Booking(int bookingId, String email, int movieId, int locationId, int theatreId, int showId, String seatId, int count, int amount) {
		this.bookingId = bookingId;
		this.email = email;
		this.movieId = movieId;
		this.locationId = locationId;
		this.theatreId = theatreId;
		this.showId = showId;
		this.seatId = seatId;
		this.count = count;
		this.amount = amount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Booking{" +
				"bookingId=" + bookingId +
				", email='" + email + '\'' +
				", movieId=" + movieId +
				", locationId=" + locationId +
				", theatreId=" + theatreId +
				", showId=" + showId +
				", seatId='" + seatId + '\'' +
				", count=" + count +
				", amount=" + amount +
				'}';
	}
}
