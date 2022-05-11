package com.example.backend.Response;

public class BookingDetails {
    String movieName;
    String locationName;
    String theatreName;
    String showTime;
    int count;

    public BookingDetails() {

    }

    public BookingDetails(String movieName, String locationName, String theatreName, String showTime, int count) {
        this.movieName = movieName;
        this.locationName = locationName;
        this.theatreName = theatreName;
        this.showTime = showTime;
        this.count = count;
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
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "movieName='" + movieName + '\'' +
                ", locationName='" + locationName + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", showTime='" + showTime + '\'' +
                ", count=" + count +
                '}';
    }
}
