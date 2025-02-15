```mermaid
---
  config:
    class:
      hideEmptyMethodBox: true
---
classDiagram
    class BaseModel{
        -Long id
        -Date createdDateTime
        -Date updateDateTime
    }
    
    BaseModel <|-- City
    class City{
        -String name
        -List~Theatre~ theatreList
    }
    City "1" --> "m" Theatre
    
    BaseModel <|-- Movie
    class Movie{
        -String name
        -Double duration 
        -List~Actor~ actors
    }
    
    Movie "1" --> "m" Actor
    
    BaseModel<|-- Actor
    class Actor{
        -String name
    }
    
    BaseModel <|-- Theatre
    class Theatre{
        -String name
        -List~Screen~ screenList
    }
    Theatre "1" --> "m" Screen
    
    BaseModel <|-- Screen
    class Screen{
        -String name
        -List~Seat~ seatList
        -ScreenStatus screenstatus
        -List~Feature~ featureList
    }
    Screen  "1" --> "m" Seat
    Screen "1" --> "m" Feature
    Screen "1" --> "1" ScreenStatus
    
    class ScreenStatus{
        <<enumeration>>
        AVAIALABLE
        UNAVAILABLE
    }
    
    class Feature{
        <<enumeration>>
        TWO_D
        THREE_D
        IMAX
        DOLBY_ATMOS
    }
    
    BaseModel <|-- Seat
    class Seat{
        -String number
        -String row
        -String column
        -SeatType seatType
    }
    
    Seat "1" --> "1" SeatType
    
    BaseModel <|-- SeatType
    class SeatType{
        -String type
    }
    
    BaseModel <|-- Show
    class Show{
        -String name
        -Date startTime
        -Date endTime
        -Screen screen
        -Theatre theatre
        -List~Feature~ features
        -List~ShowSeat~ showSeatList
        -Movie movie
    }
    Show "m" --> "1" Screen
    Show "m" --> "1" Theatre
    Show "m" --> "m" Feature 
    
    BaseModel <|-- ShowSeat
    class ShowSeat{
        -Show show
        -Seat seat
        -SeatStatus seatStatus
    }
    ShowSeat "m" --> "1" Seat
    ShowSeat "m" --> "1" Show
    ShowSeat "1" --> "1" SeatStatus
    
    class SeatStatus{
        <<enumeration>>
        AVAILABLE
        BOOKED
    }
    
    BaseModel <|-- ShowSeatType
    class ShowSeatType{
        -Show show
        -SeatType seatType
        -int price
    }
    ShowSeatType "m" --> "1" Show
    ShowSeatType "m" --> "1" SeatType
    
    BaseModel <|-- User
    class User{
        -String name
        -String email
        -String password
    }
    
    BaseModel <|-- Booking
    class Booking{
        -String referenceNumber
        -Date bookingDate
        -List~ShowSeat~ showSeat
        -Double amount
        -BookingStatus bookingStatus
        -List<Payment> payments
    }
    Booking "1" --> "m" ShowSeat
    Booking "1" --> "m" Payment
    Booking "1" --> "1" BookingStatus
    
    
    BaseModel <|-- Payment
    class Payment{
        -int amount
        -String refNumber
        -PaymentStatus paymentStatus
    }
    Payment "1" --> "1" PaymentStatus
    
    class PaymentStatus{
        <<enumeration>>
        SUCCESS,
        FAILED,
        CANCELLED,
        PENDING
    }
    
    class BookingStatus{
        <<enumeration>>
        PENDING,
        CONFIRMED,
        CANCELLED,
    }

```