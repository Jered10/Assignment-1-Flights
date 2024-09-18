package flightpack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * MyDataReader class is being used for reading flight data from a CSV file,
 * parsing it, and creating Flight objects.
 * @author Jack Bergin and Jered Kalombo
 * @version September 15, 2024
 */
public class MyDataReader {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH"); // formatter for date and time

    /**
     * Parses the date and time from a string, replacing invalid day "00" with "01".
     * 
     * @param dateTimeString the raw date and time string from the CSV
     * @return a LocalDateTime object representing the adjusted date and time
     */
    private static LocalDateTime parseDateTime(String dateTimeString) {
        String adjustedDateTimeString = dateTimeString.replaceAll("-00:", "-01:"); // Replace "00" day with "01" to handle invalid date formats
        return LocalDateTime.parse(adjustedDateTimeString, FORMATTER);
    }

    /**
     * Reads flight data from a CSV file and parses it into an array of Flight objects.
     * 
     * @param filePath the path to the CSV file
     * @return an array of Flight objects parsed from the CSV
     */
    public static Flight[] readFlightsFromCSV(String filePath) {
        List<Flight> flights = new ArrayList<>();  // List to store parsed flights
        String line;
        String delimiter = ",";  

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            // Read each line from the CSV
            while ((line = br.readLine()) != null) {
                // Split the line into fields using the comma delimiter
                String[] data = line.split(delimiter);

                // Validate the length of the line to ensure it has all required fields
                if (data.length < 10) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    // Parse origin and destination airports, passengers, seats, distance, and date/time
                    Airport origin = new Airport(data[0], data[1], data[2]);
                    Airport destination = new Airport(data[3], data[4], data[5]);
                    int passengers = Integer.parseInt(data[6]);
                    int seats = Integer.parseInt(data[7]);
                    int distance = Integer.parseInt(data[8]);
                    LocalDateTime flightDateTime = parseDateTime(data[9]);

                    // Creates a new Flight object and add it to the list
                    Flight flight = new Flight(origin, destination, passengers, seats, distance, flightDateTime);
                    flights.add(flight);

                } catch (Exception e) {
                    System.out.println("Error processing line: " + line); // deals with exceptions that occur during parsing
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath); // checks the file errors
            e.printStackTrace();
        }

        System.out.println("Total flights parsed: " + flights.size()); // Output the total number of flights parsed and return the array of Flight objects

        return flights.toArray(new Flight[0]);
    }
}