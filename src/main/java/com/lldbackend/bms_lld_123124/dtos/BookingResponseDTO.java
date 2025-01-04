package com.lldbackend.bms_lld_123124.dtos;

import com.lldbackend.bms_lld_123124.models.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BookingResponseDTO {
    private String referenceNumber;
    private List<ShowSeat> showSeatList;
    private Show show;
    private Theatre theatre;
    private Screen screen;
    private int amount;
    private Movie movie;
    private BookingStatus bookingStatus;

    @Override
    public String toString() {
        String message = "";
        if(this.bookingStatus == BookingStatus.CANCELLED){
            message = "Booking Cancelled";
        }else{
            message = "Booking Reference Number : " + referenceNumber + "\n" +
                    "Show : " + show.getName() + "\n" +
                    "Theatre : " + theatre.getName() + "\n" +
                    "Screen : " + screen.getName() + "\n" +
                    "Amount : " + amount + "\n" +
                    "Movie : " + movie.getName() + "\n" +
                    "Show Seat List : " + showSeatList.stream().map(ShowSeat::getSeat).map(Seat::getSeatNumber).map(Object::toString).collect(Collectors.joining(", "))+ "\n" +
                    "Booking Status : " + bookingStatus;
        }
        return message;
    }
}
