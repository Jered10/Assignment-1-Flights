/*
 * 
 * This program processes flight data from a CSV file and performs several analyses on it. 
 * The program uses methods from the MyDataReader and MyAnalyzer classes to perform data reading and analysis tasks.
 * 
 */
package flightpack;
import java.util.Set;
/**
 * @author Jack Bergin and Jered Kalombo
 * @version September 15, 2024
 */
public class program1 {

    // Main method to execute the program
    public static void main(String[] args) {
        // Read flights data from CSV
        Flight[] flights = MyDataReader.readFlightsFromCSV("flights.csv");

        // Measure and display the runtime for printing all flight details
        long startTime5 = System.currentTimeMillis(); // Start time
        for (Flight flight : flights) {
            // Print each flight's details: origin, destination, seats, passengers, distance, and date/time
            System.out.println(flight.getOrigin().getAirportName() + " to " + flight.getDestination().getAirportName() + 
            " Seats:" + flight.getSeats() + " Passengers:" + flight.getPassengers() + 
            " Distance:" + flight.getDistance() + " Date/Time:" + flight.getFlightDateTime());
        }
        long endTime5 = System.currentTimeMillis(); // End time
        System.out.println("Runtime for printing all flight details: " + (endTime5 - startTime5) + " ms"); // Print runtime

        // Runtime for finding unique airports in Maine
        long startTime1 = System.currentTimeMillis(); // Start time
        Set<String> maineAirports = MyAnalyzer.findMaineAirports(flights); // Get Maine airports
        long endTime1 = System.currentTimeMillis(); // End time
        System.out.println("\nAirports in Maine:");
        for (String airport : maineAirports) {
            System.out.println(airport); // Print each unique airport in Maine
        }
        System.out.println("Runtime for finding unique Maine airports: " + (endTime1 - startTime1) + " ms"); // Print runtime

        // Maximum number of passengers on flights to PWM
        long startTime2 = System.currentTimeMillis(); // Start time
        int maxPassengers = MyAnalyzer.findMaxPassengers(flights); // Find the maximum passengers
        long endTime2 = System.currentTimeMillis(); // End time
        System.out.println("Maximum passengers coming to PWM: " + maxPassengers); // Print result
        System.out.println("Runtime for finding maximum number of passengers on a flight to Portland, ME: " + (endTime2 - startTime2) + " ms"); // Print runtime

        // Calculating the percentage of flights with no empty seats
        long startTime3 = System.currentTimeMillis(); // Start time
        double fullFlights = MyAnalyzer.findFullFlights(flights); // Find percentage of full flights
        long endTime3 = System.currentTimeMillis(); // End time
        System.out.println("Percentage of flights with no empty seats: " + fullFlights + "%"); // Print result
        System.out.println("Runtime for finding percentage of flights with no empty seats: " + (endTime3 - startTime3) + " ms"); // Print runtime

        // Calculating the average number of passengers from PWM to Florida in 2009
        long startTime4 = System.currentTimeMillis(); // Start time
        double avgPassengers = MyAnalyzer.findAvgPassengersPWMToFlorida(flights); // Find average passengers
        long endTime4 = System.currentTimeMillis(); // End time
        System.out.println("Average number of passengers from Portland to Florida in 2009: " + avgPassengers); // Print result
        System.out.println("Runtime for finding average number of passengers from Portland to Florida in 2009: " + (endTime4 - startTime4) + " ms"); // Print runtime
    }
}