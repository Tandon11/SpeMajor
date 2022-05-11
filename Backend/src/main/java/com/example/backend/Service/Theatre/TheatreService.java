package com.example.backend.Service.Theatre;

import com.example.backend.Model.Theatre;

import java.util.List;

public interface TheatreService {
    public List<Theatre> listAllTheatre();
    public void addTheatre(Theatre theatre);
  
    public List<Theatre> findTheatreByMovieandLocation(int locationId,int movieid);
}
