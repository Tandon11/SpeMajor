package com.example.backend.Service.Seat;

import com.example.backend.Model.Seats;
import com.example.backend.Model.Shows;
import com.example.backend.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seats> listAllSeats() {
        return seatRepository.findAll();
    }

    public Seats addSeat(Seats seat) {
        Seats newSeat = seatRepository.save(seat);
        return newSeat;
    }

    public int getSeatCost(String seatType) {
        String cost = seatRepository.getSeatCost(seatType);
        return Integer.parseInt(cost);
    }

    public List<Seats> seatsById(Integer movieId, Integer locationId, Integer TheatreId,Integer showid) {
        return seatRepository.seatByMovieandLocationId(movieId,locationId,TheatreId,showid);
    }

    public Integer updateSeatStatus(Integer[] seatId) {
        return seatRepository.updateSeats(Arrays.asList(seatId));
    }

}
