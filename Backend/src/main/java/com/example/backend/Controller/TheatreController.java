package com.example.backend.Controller;

import com.example.backend.Model.Theatre;
import com.example.backend.Service.Theatre.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping("/theatre")
    public List<Theatre> list() {
        return theatreService.listAllTheatre();
    }

    @PostMapping("/theatre/add")
    public ResponseEntity<Theatre> add(@RequestBody Theatre theatre) {
        theatreService.addTheatre(theatre);
        return ResponseEntity.ok(theatre);

    }

    @GetMapping(value = "/getTheatre/{locationId}/{movieid}")
	public List<Theatre> getAllTheatre(@PathVariable int locationId, @PathVariable int movieid) {
        System.out.println(locationId + movieid);
		List<Theatre> theatres = theatreService.findTheatreByMovieandLocation(locationId, movieid);
		return theatres;
	}
}
