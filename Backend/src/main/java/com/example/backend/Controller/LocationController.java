package com.example.backend.Controller;

import java.util.List;

import com.example.backend.Repository.LocationRepository;
import com.example.backend.Service.Location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.Model.Location;

@RestController
@CrossOrigin("*")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private LocationRepository locationRepository;

	@GetMapping("/getAllLocation")
	public List<Location> getAllLocation() {
		List<Location> locations=locationService.getAll();
		return locations;
	}

	@PostMapping(value = "/addLocation")
	public ResponseEntity<Location> addLocation(@RequestBody Location location) {
		locationRepository.save(location);
		return ResponseEntity.ok(location);
	}

}
