package dto;

import com.example.travelo_backend.model.Passenger;

public class ReservationDto {
    private Integer flightId;
    private String seatName;
    private Passenger passenger;

    // Getters and setters

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

