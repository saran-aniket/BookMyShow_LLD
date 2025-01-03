package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    public Optional<Show> findById(Long showId);
    public Show save(Show show);
}
