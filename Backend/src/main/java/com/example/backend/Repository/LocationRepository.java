package com.example.backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.Model.Location;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Integer>{
    @Query(value = "SELECT l.location_name FROM location l WHERE l.location_id=?1",nativeQuery = true)
    String findLocationName(int locationId);
}
