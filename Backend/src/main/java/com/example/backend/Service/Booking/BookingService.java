package com.example.backend.Service.Booking;

import com.example.backend.DTO.BookingObject;
import com.example.backend.Model.Booking;
import com.example.backend.Response.BookingDetails;

import java.util.List;

public interface BookingService {
    public void addBooking(Booking booking);
    public List<Booking> listAllBooking();
    public List<BookingDetails> listByUser(String email);
  //  public boolean endBooking(Integer bookingid);
    public String[] getDate();
    public String[] getTime();
    public String[] splitDate(String date);
    public String[] splitTime(String time);

}
