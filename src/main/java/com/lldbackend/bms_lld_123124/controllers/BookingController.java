package com.lldbackend.bms_lld_123124.controllers;

import com.lldbackend.bms_lld_123124.dtos.BookingRequestDTO;
import com.lldbackend.bms_lld_123124.dtos.BookingResponseDTO;
import com.lldbackend.bms_lld_123124.models.Booking;
import com.lldbackend.bms_lld_123124.models.BookingStatus;
import com.lldbackend.bms_lld_123124.services.BookingService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {
    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingResponseDTO bookShow(BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        try {
            System.out.println("Booking Started");
            Booking booking = bookingService.saveBooking(bookingRequestDTO.getUserId(), bookingRequestDTO.getShowId(), bookingRequestDTO.getShowSeatIds());
            bookingResponseDTO.setShow(booking.getShow());
            bookingResponseDTO.setScreen(booking.getShow().getScreen());
            bookingResponseDTO.setShowSeatList(booking.getShowSeatList());
            bookingResponseDTO.setTheatre(booking.getShow().getTheatre());
            bookingResponseDTO.setMovie(booking.getShow().getMovie());
            bookingResponseDTO.setAmount(booking.getAmount());
            bookingResponseDTO.setReferenceNumber(booking.getReferenceNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            bookingResponseDTO.setBookingStatus(BookingStatus.CANCELLED);
        }
        return bookingResponseDTO;
    }
}
