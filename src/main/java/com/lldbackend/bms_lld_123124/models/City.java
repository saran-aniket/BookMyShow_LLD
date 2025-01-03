package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{
    private String name;
    @OneToMany
    private List<Theatre> theatreList;
}
