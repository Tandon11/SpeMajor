package com.example.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shows {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer showid;
    private Integer theatreId;
    private Integer movieId;
	private Integer locationId;

	private String showTime;
    private Integer status = 0;
    private String time = "0";
    private Integer duration = 0;
    
    public Shows() {
    }

	public Shows(Integer showid, Integer theatreId, Integer movieId, Integer locationId, String showTime, Integer status, String time, Integer duration) {
		this.showid = showid;
		this.theatreId = theatreId;
		this.movieId = movieId;
		this.locationId = locationId;
		this.showTime = showTime;
		this.status = status;
		this.time = time;
		this.duration = duration;
	}

	public Integer getShowid() {
		return showid;
	}

	public void setShowid(Integer showid) {
		this.showid = showid;
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}

