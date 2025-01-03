package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    Theatre save(Theatre theatre);
    Theatre findByName(String name);
    List<Theatre> findAll();
}
