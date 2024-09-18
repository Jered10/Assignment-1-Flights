package flightpack;
/**
 * @author Jack Bergin and Jered Kalombo
 * @version September 15, 2024
 */
public class Airport {
    private String airportName;
    private String city;
    private String state;
    
    /**
     * Initializing an Airport object with the given name, city, and state.
     * 
     * @param airportName the name of the airport
     * @param city the city where the airport is located
     * @param state the state where the airport is located
     */
    public Airport(String airportName, String city, String state) {
        this.airportName = airportName;
        this.city = city;
        this.state = state;
    }
    
    /**
     * Gets the name of the airport.
     * 
     * @return the name of the airport
     */
    public String getAirportName() {
        return airportName;
    }
    
    /**
     * Gets the city where the airport is located.
     * 
     * @return the city of the airport
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Gets the state where the airport is located.
     * 
     * @return the state of the airport
     */
    public String getState() {
        return state;
    }
}