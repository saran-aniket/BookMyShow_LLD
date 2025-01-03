package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
    SeatType save(SeatType seatType);
    SeatType findBySeatTypeName(String name);
    List<SeatType> findAll();
}
