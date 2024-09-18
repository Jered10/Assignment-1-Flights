# Flight Data Analysis Program

## Overview

This program processes flight data from a CSV file and performs various analyses. It uses methods from the `MyDataReader` and `MyAnalyzer classes to read and analyze flight data, including details about flights, airports, and passenger statistics.

## Features

- **Read Flight Data**: Reads flight information from a CSV file.
- **Print Flight Details**: This function outputs details for all flights, including origin, destination, number of seats, passengers, distance, and date/time.
- **Analyze Airports**: Identifies unique Maine (ME) airports.
- **Passenger Statistics**: 
  - Finds the maximum number of passengers on flights arriving at Portland International Jetport (PWM).
  - Calculates the percentage of fully booked flights (no empty seats).
  - Computes the average number of passengers on flights from PWM to Florida (FL) during 2009.

## Classes

- `program1`: The main class orchestrates reading flight data and performing analyses.
- `MyDataReader`: Responsible for reading data from the CSV file and parsing it into `Flight` objects.
- `MyAnalyzer`: Contains methods for analyzing flight data, including airport and passenger statistics.
`Flight` represents a flight with details such as origin, destination, passengers, seats, distance, and flight date/time.
- `Airport`: Represents an airport with its name, city, and state.

## Usage

1. Ensure you have a valid CSV file named `flights.csv` in the same directory as the program.
2. Compile and run the `program1` class.

## CSV File Format

The CSV file should contain the following columns:

1. Origin Airport Name
2. Origin City
3. Origin State
4. Destination Airport Name
5. Destination City
6. Destination State
7. Number of Passengers
8. Total Seats
9. Distance
10. Flight Date and Time (format: yyyy-MM-dd:HH)



## Dependencies

- Java Development Kit (JDK) for compiling and running the program.

## Authors

Jered Kalombo & Jack Bergin

## License

Copyright(c) [2024] 
