package com.example.backend.Controller;

import com.example.backend.Model.Shows;
import com.example.backend.Service.Show.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/shows/getAll")
    public List<Shows> listAll(){
        return showService.listAllShows();
    }

    @GetMapping("/shows/getbyid/{MovieId}/{LocationId}/{theatreId}")
    public List<Shows> showById(@PathVariable int MovieId,@PathVariable int LocationId,@PathVariable int theatreId) {
        List<Shows> shows = showService.showsById(MovieId,LocationId,theatreId);
        System.out.println("Fetched Value :"+shows);
        return shows;
    }

    @GetMapping("/shows/getbyShowID/{MoviedId}/{LocationId}/{theatreId}/{showid}")
    public List<Shows> showByAllIds(@PathVariable int MovieId,@PathVariable int LocationId,@PathVariable int theatreId,@PathVariable int showid) {
    	 List<Shows> shows = showService.showsByAllIds(MovieId,LocationId,theatreId,showid);
    	 return shows;
    }

    @PostMapping("/shows/add")
    public boolean add(@RequestBody Shows show) {
        return showService.addShow(show);
    }
}
