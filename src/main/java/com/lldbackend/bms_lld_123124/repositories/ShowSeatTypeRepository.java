package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    ShowSeatType save(ShowSeatType showSeatType);
    List<ShowSeatType> findAll();
}
