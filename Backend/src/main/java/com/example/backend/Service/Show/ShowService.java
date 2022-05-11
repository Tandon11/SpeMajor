package com.example.backend.Service.Show;

import com.example.backend.Model.Booking;
import com.example.backend.Model.Shows;

import java.util.List;

public interface ShowService {
    public List<Shows> listAllShows();
    public boolean addShow(Shows show);
    public List<Shows> showsById(int movieId, int locationId, int TheatreId);
  //  public void updateShow(Booking booking);
   // public void rollbackShow(String showid);]
    public List<Shows> showsByAllIds(int movieId, int locationId, int TheatreId,int showid);
}
