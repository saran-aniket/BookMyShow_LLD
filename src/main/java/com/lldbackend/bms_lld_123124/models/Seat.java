package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel {
    @Column(name = "seat_number")
    private String seatNumber;
    @Column(name = "seat_row")
    private String row;
    @Column(name = "seat_column")
    private String column;
    @ManyToOne
    private SeatType seatType;
}
