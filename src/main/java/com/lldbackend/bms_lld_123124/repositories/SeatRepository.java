package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat save(Seat seat);
    Seat findBySeatNumber(String name);
    List<Seat> findAll();
}
