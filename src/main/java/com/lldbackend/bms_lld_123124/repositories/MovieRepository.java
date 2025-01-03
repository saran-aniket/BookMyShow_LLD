package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie save(Movie movie);
    Movie findByName(String name);
    List<Movie> findAll();
}
