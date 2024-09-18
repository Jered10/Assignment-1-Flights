package flightpack;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * MyAnalyzer class provides various methods to analyze flight data.
 * @author Jack Bergin and Jered Kalombo
 * @version September 15, 2024
 */
public class MyAnalyzer {
    
    /**
     * Finds all airport names in the state of Maine (ME) from a list of flights.
     * 
     * @param flights an array of Flight objects
     * @return a set of unique airport names in Maine
     */
    public static Set<String> findMaineAirports(Flight[] flights) {
        Set<String> maineAirports = new HashSet<>(); 
        
        // Loop through each flight to check if origin/destination is in Maine
        for (Flight flight : flights) {
            if ("ME".equals(flight.getOrigin().getState())) {
                maineAirports.add(flight.getOrigin().getAirportName());
            }
            if ("ME".equals(flight.getDestination().getState())) {
                maineAirports.add(flight.getDestination().getAirportName());
            }
        }
        
        return maineAirports;
    }

    /**
     * Finds the maximum number of passengers on flights with Portland International Jetport (PWM)
     * as the destination.
     * 
     * @param flights an array of Flight objects
     * @return the maximum number of passengers on a flight to PWM
     */
    public static int findMaxPassengers(Flight[] flights) {
        int maxPassengers = 0;
        
        // Loop through each flight and check if destination is PWM
        for (Flight flight : flights) {
            if ("PWM".equals(flight.getDestination().getAirportName())) {
                if (flight.getPassengers() > maxPassengers) {
                    maxPassengers = flight.getPassengers();
                }
            }
        }
        return maxPassengers;
    }

    /**
     * Calculates the percentage of full flights.
     * 
     * @param flights an array of Flight objects
     * @return the percentage of full flights
     */
    public static double findFullFlights(Flight[] flights) {
        int totalFlights = flights.length;
        int fullFlights = 0;
        
        // Loops through each flight to check if it's full
        for (Flight flight : flights) {
            if (flight.getPassengers() == flight.getSeats()) {
                fullFlights++;
            }
        }
        
        // Calculate percentage of full flights
        double percentage = ((double) fullFlights / totalFlights) * 100;
        DecimalFormat df = new DecimalFormat("#.##"); // Format to two decimal places
        return Double.parseDouble(df.format(percentage));
    }

    /**
     * Finds the average number of passengers on flights from Portland International Jetport (PWM)
     * to Florida (FL) in the year 2009.
     * 
     * @param flights an array of Flight objects
     * @return the average number of passengers for flights from PWM to FL in 2009
     */
    public static double findAvgPassengersPWMToFlorida(Flight[] flights) {
        int totalPassengers = 0;
        int flightCount = 0;
        
        // Loop through each flight and check if it is from PWM to a Florida airport in 2009
        for (Flight flight : flights) {
            if ("PWM".equals(flight.getOrigin().getAirportName()) 
                && isFlorida(flight.getDestination().getState()) 
                && flight.getFlightDateTime().getYear() == 2009) {
                
                totalPassengers += flight.getPassengers();
                flightCount++;
            }
        }

        // Avoids 0 if no flights match
        if (flightCount == 0) {
            return 0.0;
        }

        // Calculates the average passengers
        double avg = (double) totalPassengers / flightCount;
        DecimalFormat df = new DecimalFormat("#.##"); // Format to two decimal places
        return Double.parseDouble(df.format(avg));
    }

    /**
     * Helper method to check if a given state is Florida (FL).
     * 
     * @param state the state code
     * @return true if the state is Florida, otherwise false
     */
    public static boolean isFlorida(String state) {
        return "FL".equals(state);
    }
}