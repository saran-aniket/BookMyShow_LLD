package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    private String name;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Theatre theatre;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Movie movie;
    @OneToMany
    private List<ShowSeat> showSeatList;
}
