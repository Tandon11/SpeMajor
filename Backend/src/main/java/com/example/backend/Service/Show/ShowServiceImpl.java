package com.example.backend.Service.Show;

import com.example.backend.Model.Booking;
import com.example.backend.Model.Shows;
import com.example.backend.Repository.ShowRepository;
import com.example.backend.Repository.TheatreRepository;
import com.example.backend.Service.Theatre.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    public List<Shows> listAllShows() {
        return showRepository.findAll();
    }

    public boolean addShow(Shows show) {
        if(theatreRepository.existsById(show.getTheatreId())){
            System.out.println(theatreRepository.existsById(show.getTheatreId()));
            showRepository.save(show);
            return true;
        }
        else
            return false;
    }

    public List<Shows> showsById(int movieId, int locationId, int TheatreId) {
        return showRepository.showByMovieandLocationId(movieId,locationId,TheatreId);
    }

    public List<Shows> showsByAllIds(int movieId, int locationId, int TheatreId,int showid) {
		return showRepository.showByAllIds(movieId,locationId,TheatreId,showid);
    }

   // public void updateShow(Booking booking) {
   //     showRepository.updateShow(1, booking.getTime(), booking.getTicketCount(), booking.getShowid());
   // }

  //  public void rollbackShow(String showid) {
  //      showRepository.rollbackShow(showid);
  //  }
}
