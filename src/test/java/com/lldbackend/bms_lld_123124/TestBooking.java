package com.lldbackend.bms_lld_123124;

import com.lldbackend.bms_lld_123124.controllers.BookingController;
import com.lldbackend.bms_lld_123124.dtos.BookingRequestDTO;
import com.lldbackend.bms_lld_123124.dtos.BookingResponseDTO;
import com.lldbackend.bms_lld_123124.models.Seat;
import com.lldbackend.bms_lld_123124.models.Show;
import com.lldbackend.bms_lld_123124.models.ShowSeat;
import com.lldbackend.bms_lld_123124.models.User;
import com.lldbackend.bms_lld_123124.repositories.SeatRepository;
import com.lldbackend.bms_lld_123124.repositories.ShowRepository;
import com.lldbackend.bms_lld_123124.repositories.ShowSeatRepository;
import com.lldbackend.bms_lld_123124.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestBooking {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private BookingController bookingController;

    @Test
    public void testSaveBooking() {
        BookingRequestDTO bookingRequestDTO = new BookingRequestDTO();
        bookingRequestDTO.setUserId(1L);
        bookingRequestDTO.setShowId(1L);
        bookingRequestDTO.setShowSeatIds(List.of(26L, 27L, 28L));
        BookingResponseDTO bookingResponseDTO = bookingController.bookShow(bookingRequestDTO);
        System.out.println(bookingResponseDTO);
    }
}
