package com.example.backend.Model;

import javax.persistence.*;

@Entity
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seatid;
    private String seat_type;
    private String cost;

    //@Column(columnDefinition = "integer default 0")
    private Integer status = 0;
    private Integer showid;
    private Integer theatreId;
    private Integer locationId;
    private Integer movieId;

    public Seats() {
    }

    public Seats(Integer seatid, String seat_type, String cost, Integer status, Integer theatreId, Integer locationId, Integer movieId,Integer showId) {
        this.seatid = seatid;
        this.seat_type = seat_type;
        this.cost = cost;
        this.status = status;
        this.theatreId = theatreId;
        this.locationId = locationId;
        this.movieId = movieId;
        this.showid=showid;
    }

    public Integer getSeatid() {
        return seatid;
    }

    public void setSeatid(Integer seatid) {
        this.seatid = seatid;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

	public Integer getShowid() {
		return showid;
	}

	public void setShowid(Integer showid) {
		this.showid = showid;
	}
    
}
