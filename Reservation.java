package Feb_15_FlightReservationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Reservation
{
    List<Flight> flightList;
    int i = 0;
    int count = 0;

    Reservation() {
        flightList = new ArrayList<>();

    }

    //Add Flights
    Scanner sc = new Scanner(System.in);

    public void addFlight() {
        System.out.println("Enter the Flight number");
        int flightNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the departure city");
        String departureCity = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the destination city");
        String destinationCity = sc.nextLine();
        System.out.println("Enter the avilable seat");
        int availableSeats = sc.nextInt();

        Flight newflight = new Flight(flightNumber, departureCity, destinationCity, availableSeats);
        flightList.add(newflight);
        System.out.println("Flight has been added successfully");
    }

    public void reserve() throws ReservationException {
        sc.nextLine();
        System.out.println("Enter name of user");
        String name = sc.nextLine();
        System.out.println("Enter the phone no. of user");
        String phoneNumber = sc.next();
        System.out.println("Enter how many no. of seats you want to book");
        int n = sc.nextInt();
        System.out.println("Flights are:");
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
        System.out.println("Enter the flight no. which you want to book");
        int flightNumber = sc.nextInt();
        Flight flighttoReserve = null;
        for (Flight flight : flightList) {
            if (flightNumber == flight.getFlightNum()) {
                flighttoReserve = flight;
                break;
            } else if (flightNumber != flight.getFlightNum()) {
                throw new ReservationException.NonExistingFlights();
            }
        }
        if (flighttoReserve.getAvailableseats() == 0) {
            throw new ReservationException.FullyBookedFlightException();
        }
        int newAvailabe = flighttoReserve.getAvailableseats() - n;
        if (newAvailabe < 0) {
            throw new ReservationException.NegativeAvailableSeats();
        }
        flighttoReserve.setAvailableseats(flighttoReserve.getAvailableseats() - n);

        for (int j = 1; j <= n; j++) {
            i++;
            count++;
            user newuser = new user(i, name, phoneNumber, count);
            flighttoReserve.userList.add(newuser);
            System.out.println("Users' Ticket no. is " + i);
        }

        System.out.println(n + " Flights are booked");
    }

    //Cancel Flight
    public void cancelling() throws ReservationException {
        System.out.println("Enter the flight no. which you have booked");
        int flightNumber = sc.nextInt();
        System.out.println("Enter your Ticket no.");
        int ticketNumber = sc.nextInt();
        Flight flighttoCancel = null;
        for (Flight flight : flightList) {
            if (flightNumber == flight.getFlightNum()) {
                flighttoCancel = flight;
                break;
            } else if (flighttoCancel.getFlightNum() != flightNumber) {
                throw new ReservationException.NonExistingFlights();
            }
        }
        if (flighttoCancel != null) {
            user usertoDelete = null;
            for (user user : flighttoCancel.userList) {
                if (ticketNumber == user.getTicketnum()) {
                    usertoDelete = user;
                    break;
                } else {
                    System.out.println("User has not reserved this flight");
                }
            }
            if (usertoDelete != null) {
                flighttoCancel.userList.remove(usertoDelete);
            }
            System.out.println("Flight is cancelled");
        }
    }
    //display Flights

    public void displayFlights() {


        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }
}