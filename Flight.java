package flightpack;
import java.time.LocalDateTime;
/**
 * @author Jack Bergin and Jered Kalombo
 * @version September 15, 2024
 */
public class Flight {
    
    // Private fields
    private Airport origin;
    private Airport destination;
    private LocalDateTime flightDateTime;  // Date & time of flight
    private int passengers;                // Passengers on the flight
    private int seats;                     // Available seats on the flight
    private int distance;                  // Distance of the flight in miles/kilometers

    /**
     * Initialize a Flight object with the given details.
     * 
     * @param origin the originating airport of the flight
     * @param destination the destination airport of the flight
     * @param passengers the number of passengers on the flight
     * @param seats the total number of seats on the flight
     * @param distance the distance of the flight
     * @param flightDateTime the scheduled date and time of the flight
     */
    public Flight(Airport origin, Airport destination, int passengers, int seats, int distance, LocalDateTime flightDateTime) {
        this.origin = origin;
        this.destination = destination;
        this.passengers = passengers;
        this.seats = seats;
        this.distance = distance;
        this.flightDateTime = flightDateTime;
    }

    /**
     * Gets the originating airport of the flight.
     * 
     * @return the origin airport
     */
    public Airport getOrigin() {
        return origin;
    }

    /**
     * Gets the destination airport of the flight.
     * 
     * @return the destination airport
     */
    public Airport getDestination() {
        return destination;
    }

    /**
     * Gets the scheduled date and time of the flight.
     * 
     * @return the flight date and time
     */
    public LocalDateTime getFlightDateTime() {
        return flightDateTime;
    }

    /**
     * Gets the number of passengers on the flight.
     * 
     * @return the number of passengers
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Gets the total number of seats on the flight.
     * 
     * @return the number of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Gets the distance of the flight.
     * 
     * @return the flight distance
     */
    public int getDistance() {
        return distance;
    }
}