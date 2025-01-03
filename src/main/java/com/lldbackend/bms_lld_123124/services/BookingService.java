package com.lldbackend.bms_lld_123124.services;

import com.lldbackend.bms_lld_123124.exceptions.ShowNotFoundException;
import com.lldbackend.bms_lld_123124.exceptions.ShowSeatNotFoundException;
import com.lldbackend.bms_lld_123124.exceptions.UserNotFoundException;
import com.lldbackend.bms_lld_123124.models.*;
import com.lldbackend.bms_lld_123124.repositories.BookingRepository;
import com.lldbackend.bms_lld_123124.repositories.ShowRepository;
import com.lldbackend.bms_lld_123124.repositories.ShowSeatRepository;
import com.lldbackend.bms_lld_123124.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final RandomStringGeneratorService randomStringGeneratorService;

    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          RandomStringGeneratorService randomStringGeneratorService) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.randomStringGeneratorService = randomStringGeneratorService;
    }

    public Booking saveBooking(Long userId, Long showId, List<Long> showSeatIdList) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        User user = userOptional.get();
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()) {
            throw new ShowNotFoundException("Show not found");
        }
        Show show = showOptional.get();
        List<ShowSeat> showSeatList = showSeatRepository.findAllById(showSeatIdList);
        for(ShowSeat showSeat : showSeatList){
            if(showSeat.getSeatStatus() != SeatStatus.AVAILABLE){
                throw new RuntimeException("Seat number " + showSeat.getSeat().getSeatNumber() + " is not available");
            }
        }
        List<ShowSeat> showSeatListToSave = new ArrayList<>();
        for(ShowSeat showSeat : showSeatList){
            showSeat.setSeatStatus(SeatStatus.BOOKED);
            showSeatListToSave.add(showSeat);
        }
        List<ShowSeat> savedShowSeatList = showSeatRepository.saveAll(showSeatListToSave);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeatList(savedShowSeatList);
        booking.setScreen(show.getScreen());
        booking.setTheatre(show.getTheatre());
        booking.setShow(show);
        booking.setReferenceNumber(randomStringGeneratorService.generateRandomString(10));
        return bookingRepository.save(booking);
    }
}
