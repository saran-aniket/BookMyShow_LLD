package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private double rating;
    private String genre;
    private double duration;
    @OneToMany
    private List<Actor> actorList;
}
