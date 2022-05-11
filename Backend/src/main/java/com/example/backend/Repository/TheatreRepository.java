package com.example.backend.Repository;

import com.example.backend.Model.Theatre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    @Query(value = "SELECT t.theatre_name FROM theatre t WHERE t.theatre_id = ?1", nativeQuery = true)
    String findTheatreByTheatreName(int theatreId);

    @Query("select theatreId from Theatre where theatreName = ?1")
    public int getTheatreId(String name);

    @Query("from Theatre where locationId=?1 and MovieID =?2")
	public List<Theatre> findByMovieIdandLocationId(int locationId,int movieid);
    
}
