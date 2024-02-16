package Feb_15_FlightReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class Flight
{
    private int flightNum;
    private String departurecity;
    private String destinationcity;
    private int availableseats;
    List<user>userList;
    public Flight(int flightNum ,String departurecity,String destinationcity ,int availableseats )
    {
        this.flightNum = flightNum;
        this.departurecity = departurecity;
        this.destinationcity = destinationcity;
        this.availableseats = availableseats;
        userList= new ArrayList<>();
    }
  // getter for get the value
    public int getFlightNum()
    {
        return flightNum;
    }

    public String getDeparturecity()
    {
        return departurecity;
    }

    public String getDestinationcity()
    {
        return destinationcity;
    }

    public int getAvailableseats()
    {
        return availableseats;
    }
    // use setter for set the value

    public void setFlightNum(int flightNum)
    {
        this.flightNum = flightNum;
    }

    public void setDeparturecity(String departurecity) {
        this.departurecity = departurecity;
    }

    public void setDestinationcity(String destinationcity) {
        this.destinationcity = destinationcity;
    }

    public void setAvailableseats(int availableseats)
    {
        this.availableseats = availableseats;
    }
    @Override
    public String toString()
    {
        return ("Flight Number: " + flightNum + ", Departure City: " + departurecity +
                ", Destination City: " + destinationcity+ ", Available Seats: " + availableseats);
    }

}
