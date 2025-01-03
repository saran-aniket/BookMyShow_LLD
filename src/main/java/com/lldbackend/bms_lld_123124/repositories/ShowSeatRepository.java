package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    public Optional<ShowSeat> findById(Long showSeatId);
    public List<ShowSeat> findAllById(Iterable<Long> showSeatIdList);

    public ShowSeat save(ShowSeat showSeat);
//    List<ShowSeat> saveAll(List<ShowSeat> showSeatList);
}
