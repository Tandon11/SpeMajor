package com.example.backend.Controller;

import com.example.backend.DTO.BookingObject;
import com.example.backend.Model.Booking;
import com.example.backend.Response.BookingDetails;
import com.example.backend.Service.Booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking/add")
    public ResponseEntity<Integer> add(@RequestBody Booking booking) {
        System.out.println("booking: "+booking);
        bookingService.addBooking(booking);
        return ResponseEntity.ok(123);
    }

    @GetMapping("/booking")
    public List<Booking> listAll(){
        return bookingService.listAllBooking();
    }

    @GetMapping("booking/getByUser/{email}")
    public ResponseEntity<List<BookingDetails>> listByUsers(@PathVariable("email") String email){
        List<BookingDetails> b1 = bookingService.listByUser(email);

        System.out.println("in controller"+b1.toString() + "\n");
        return ResponseEntity.ok(b1);
    }

    @GetMapping("/booking/allBooking")
    public List<Booking> allBookings(){
        return bookingService.listAllBooking();
    }
}
