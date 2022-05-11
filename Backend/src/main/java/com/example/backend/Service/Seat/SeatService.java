package com.example.backend.Service.Seat;

import com.example.backend.Model.Seats;

import java.util.List;

public interface SeatService {
    public List<Seats> listAllSeats();
    public Seats addSeat(Seats seat);
    public int getSeatCost(String seatType);
    public List<Seats> seatsById(Integer movieId, Integer locationId, Integer TheatreId, Integer showid);
    public Integer updateSeatStatus(Integer[] seatId);
}
