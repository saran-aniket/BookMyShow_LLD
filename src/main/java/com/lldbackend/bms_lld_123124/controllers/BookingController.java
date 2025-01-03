package com.lldbackend.bms_lld_123124.controllers;

import com.lldbackend.bms_lld_123124.services.BookingService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {
    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void bookShow(Long userId, Long showId, List<Long> showSeatIds) {
        try{
            System.out.println("Booking Started");
            bookingService.saveBooking(userId, showId, showSeatIds);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
