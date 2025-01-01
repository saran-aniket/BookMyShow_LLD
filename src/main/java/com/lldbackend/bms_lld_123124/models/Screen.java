package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    private int capacity;
    @OneToMany
    private List<Seat> seatList;
    @Enumerated(EnumType.STRING)
    private ScreenStatus screenStatus;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ScreenFeature> screenFeatureList;
}
