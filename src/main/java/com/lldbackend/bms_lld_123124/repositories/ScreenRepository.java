package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    Screen save(Screen screen);
    Screen findByName(String name);
    List<Screen> findAll();
}
