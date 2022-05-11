package com.example.backend.Service.Booking;

import com.example.backend.DTO.BookingObject;
import com.example.backend.Model.Booking;
import com.example.backend.Repository.*;
import com.example.backend.Response.BookingDetails;
import com.example.backend.Service.Seat.SeatService;
import com.example.backend.Service.Show.ShowService;
import com.example.backend.Service.Theatre.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private SeatService seatService;

    @Autowired
    private SeatRepository seats;

    @Autowired
    private ShowService showService;
    int amount=0;

    public void addBooking(Booking booking) {

        bookingRepository.save(booking);
        /*
        String Seats = booking.getSeatId();
        System.out.println("Seat Id's: "+Seats+"\n");

        String[] strArray = Seats.split(",");
        int[] seatId = new int[strArray.length];

        for(int i = 0; i < strArray.length; i++) {
            seatId[i] = Integer.parseInt(strArray[i]);
        }
        */

        /*
        for(int i = 0; i < seatId.length; i++) {
            System.out.println(seatId[i] + " ");
        }
        */


       /*
        for(int i=0;i<count.length;i++) {
          String cost=seats.getCostById(count[i]);
          Integer price=Integer.parseInt(cost);
          amount=amount+price;
        }
        */
//        Booking b1 = new Booking(booking.getEmail(),booking.getMovieId(),booking.getLocationId(),booking.getTheatreId(),booking.getShowId(),booking.getSeatId(),count.length);
//        bookingRepository.save(b1);
//        return b1;
    }

    public List<Booking> listAllBooking() {
        return bookingRepository.findAll();
    }

    public List<BookingDetails> listByUser(String email) {
        List<Booking> temp = bookingRepository.findAllByEmail(email);
        List<BookingDetails> result = new ArrayList<BookingDetails>();
        System.out.println("Temp Size:" +temp.size()+ "\n");
        System.out.println("Email: " +email+ "\n");

        for(int i=0; i<temp.size(); i++) {
            String movieName = movieRepository.findmovieName(temp.get(i).getMovieId());
            String locationName = locationRepository.findLocationName(temp.get(i).getLocationId());
            String theatreName = theatreRepository.findTheatreByTheatreName(temp.get(i).getTheatreId());
            String showTime = showRepository.findShowByShowTime(temp.get(i).getShowId());
            int count = bookingRepository.findCountById(temp.get(i).getBookingId());

            BookingDetails b1 = new BookingDetails(movieName, locationName, theatreName, showTime, count);
            result.add(b1);

            System.out.println("Movie Name: " +movieName + "\n");
            System.out.println("Location Name: " +locationName + "\n");
            System.out.println("Theatre Name: " +theatreName + "\n");
            System.out.println("Showtime: " +showTime + "\n");
            System.out.println("Number Of Tickets: " +count + "\n");
        }

        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i).toString());
        }

        return result;
    }

   // public boolean endBooking(Integer bookingid) {
      //  bookingRepository.endBooking(bookingid);

      //  int ticketCount = bookingRepository.findById(bookingid).get().getTicketCount();
      //  Booking currBooking = bookingRepository.findById((bookingid)).get();
       // currBooking.setTicketCount(ticketCount);

    //    int seatCost = seatService.getSeatCost(currBooking.getSeat_type());
     //   int cost = seatCost * ticketCount;
     //   currBooking.setCost(String.valueOf(cost));

      //  bookingRepository.save(currBooking);
     //   showService.rollbackShow(currBooking.getShowid());
      //  return true;
   // }

    public String[] getDate() {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        String time = sd.format(date);
        String[] dateArray = time.split("-");
        return (dateArray);
    }

    public String[] getTime() {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        String time = sd.format(date);
        String[] timeArray = time.split(":");
        return (timeArray);
    }

    public String[] splitDate(String date) {
        return date.split("-");
    }

    public String[] splitTime(String time) {
        return time.split("-");
    }
}
