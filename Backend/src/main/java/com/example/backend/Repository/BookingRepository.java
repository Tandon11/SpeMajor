package com.example.backend.Repository;

import com.example.backend.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "select * from booking where email = ?1", nativeQuery = true)
    List<Booking> listBookingByUser(String email);

    List<Booking> findAllByEmail(String email);

    @Query(value = "SELECT b.count FROM booking b WHERE b.booking_id = ?1", nativeQuery = true)
    int findCountById(int bookingId);

    //@Modifying
   // @Transactional
   // @Query("update Booking b set b.paid = 1 where b.bookingid = ?1")
   // int endBooking(Integer bookingid);
}
