package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.City;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    City save(City city);
    City findByName(String name);
    List<City> findAll();
}
