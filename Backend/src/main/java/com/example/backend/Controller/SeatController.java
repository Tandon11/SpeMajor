package com.example.backend.Controller;

import com.example.backend.Model.Seats;
import com.example.backend.Model.Shows;
import com.example.backend.Service.Seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/getAllSeats")
    public List<Seats> list() {
        return seatService.listAllSeats();
    }

    @PostMapping("/seat/add")
    public ResponseEntity<Seats> add(@RequestBody Seats seat) {
        return new ResponseEntity<Seats>(seatService.addSeat(seat), HttpStatus.OK);
    }

    @GetMapping("/seats/getbyid/{MovieId}/{LocationId}/{theatreId}/{showid}")
    public List<Seats> seatsById(@PathVariable Integer MovieId, @PathVariable Integer LocationId, @PathVariable Integer theatreId,@PathVariable Integer showid) {
        return seatService.seatsById(MovieId, LocationId, theatreId,showid);
    }

    @PutMapping("/seats/updatebyid/{seatId}")
    public ResponseEntity<Integer> updateSeatsById(@PathVariable Integer[] seatId) {
         seatService.updateSeatStatus(seatId);
         System.out.println("hi");
         System.out.println("byei");
         System.out.println("1");
         return new ResponseEntity<Integer>(1, HttpStatus.OK);
         
    }

}
