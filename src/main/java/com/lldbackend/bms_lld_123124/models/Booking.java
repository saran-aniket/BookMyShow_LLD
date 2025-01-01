package com.lldbackend.bms_lld_123124.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private int referenceNumber;
    private Date bookingDate;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Theatre theatre;
    @OneToMany
    private List<ShowSeat> showSeatList;
    @ManyToOne
    private Movie movie;
    @OneToOne
    private User user;
    private int amount;
    @OneToMany
    private List<Payment> paymentList;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
}
