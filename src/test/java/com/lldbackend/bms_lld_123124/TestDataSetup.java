package com.lldbackend.bms_lld_123124;

import com.lldbackend.bms_lld_123124.models.*;
import com.lldbackend.bms_lld_123124.repositories.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDataSetup {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SeatTypeRepository seatTypeRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;

    @Test
    @Order(1)
    public void createTestUser(){
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUserName("johndoe@abc.com");
        user.setPassword(bCryptPasswordEncoder.encode("johnDoe123"));
        userRepository.save(user);

        User user2 = new User();
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setUserName("janeDoe@abc.com");
        user2.setPassword(bCryptPasswordEncoder.encode("janeDoe123"));
        userRepository.save(user2);
    }

    @Test
    @Order(2)
    public void createTestCity(){
        City city = new City();
        city.setName("Bangalore");
        cityRepository.save(city);

        City city2 = new City();
        city2.setName("Mumbai");
        cityRepository.save(city2);
    }

    @Test
    @Order(3)
    public void createTestScreen(){
        List<ScreenFeature> screenFeatures1 = List.of(ScreenFeature.DOLBY_ATMOS,ScreenFeature.THREE_D,ScreenFeature.IMAX);
        List<ScreenFeature> screenFeatures2 = List.of(ScreenFeature.IMAX,ScreenFeature.TWO_D);
        for(int i=0;i<4;i++){
            Screen screen = new Screen();
            screen.setName("AUDI "+(i+1));
            screen.setScreenStatus(ScreenStatus.AVAILABLE);
            screen.setCapacity(100);
            screen.setScreenFeatureList(i<=1?screenFeatures1:screenFeatures2);
            screenRepository.save(screen);
        }
    }

    @Test
    @Order(4)
    public void createTestTheatre(){
        Theatre theatre = new Theatre();
        theatre.setName("PVR Marathahalli");
        theatre.setCity(cityRepository.findByName("Bangalore"));
        theatre.setScreenList(screenRepository.findAll());
        theatreRepository.save(theatre);

        Theatre theatre2 = new Theatre();
        theatre2.setName("INOX Malad");
        theatre2.setCity(cityRepository.findByName("Mumbai"));
        theatre.setScreenList(screenRepository.findAll());
        theatreRepository.save(theatre2);
    }

    @Test
    @Order(5)
    public void createTestMovie(){
        Movie movie = new Movie();
        movie.setName("Avengers: Endgame");
        movie.setDuration(180);
        movie.setGenre("Action");
        movie.setRating(4.5);
        movieRepository.save(movie);

        Movie movie2 = new Movie();
        movie2.setName("The Dark Knight");
        movie2.setDuration(152);
        movie2.setGenre("Action");
        movie2.setRating(4.7);
        movieRepository.save(movie2);
    }

    @Test
    @Order(6)
    public void createTestShow(){
        List<String> showStartTimings = List.of("2021-08-24 09:00:00","2021-08-24 12:00:00","2021-08-24 15:00:00","2021-08-24 18:00:00");
        List<String> showEndTimings = List.of("2021-08-24 12:00:00","2021-08-24 15:00:00","2021-08-24 18:00:00","2021-08-24 21:00:00");
        List<ScreenFeature> featureList = List.of(ScreenFeature.DOLBY_ATMOS,ScreenFeature.THREE_D,ScreenFeature.IMAX);
        for(Movie movie : movieRepository.findAll()){
            for(String startTime : showStartTimings){
                int i = showStartTimings.indexOf(startTime);
                Show show = new Show();
                show.setName(movie.getName()+" "+startTime);
                show.setStartTime(Timestamp.valueOf(startTime));
                show.setEndTime(Timestamp.valueOf(showEndTimings.get(i)));
                show.setMovie(movie);
                show.setScreen(screenRepository.findByName("AUDI "+(i+1)));
                show.setTheatre(theatreRepository.findByName("PVR Marathahalli"));
                showRepository.save(show);
            }
        }
    }

    @Test
    @Order(7)
    public void createTestSeatType(){
        SeatType seatType = new SeatType();
        seatType.setSeatTypeName("GOLD");
        seatTypeRepository.save(seatType);

        SeatType seatType2 = new SeatType();
        seatType2.setSeatTypeName("SILVER");
        seatTypeRepository.save(seatType2);
    }

    @Test
    @Order(8)
    public void createSeatTest(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                Seat seat = new Seat();
                seat.setRow(String.valueOf(i));
                seat.setColumn(String.valueOf(j));
                seat.setSeatNumber(((char)('A'+i))+""+(j+1));
                seat.setSeatType(seatTypeRepository.findBySeatTypeName(i<=5?"GOLD":"SILVER"));
                seatRepository.save(seat);
            }
        }
    }

    @Test
    @Order(9)
    public void createShowSeatTest(){
        for(Show show : showRepository.findAll()){
            for(Seat seat : seatRepository.findAll()){
                ShowSeat showSeat = new ShowSeat();
                showSeat.setShow(show);
                showSeat.setSeat(seat);
                showSeat.setSeatStatus(SeatStatus.AVAILABLE);
                showSeatRepository.save(showSeat);
            }
        }
    }

    @Test
    @Order(10)
    public void createShowSeatTypeTest(){
        for(Show show : showRepository.findAll()){
            for(SeatType seatType : seatTypeRepository.findAll()){
                ShowSeatType showSeatType = new ShowSeatType();
                showSeatType.setShow(show);
                showSeatType.setSeatType(seatType);
                showSeatType.setPrice(seatType.getSeatTypeName().equals("GOLD")?500:300);
                showSeatTypeRepository.save(showSeatType);
            }
        }
    }

}
