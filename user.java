package Feb_15_FlightReservationSystem;

public class user
{
    private String name ;
    private String phonenum;
    private  int ticketnum;
    private int id ;
    public user (int id ,String name , String phonenum , int ticketnum)
    {
        this.id = id;
        this.name = name;
        this.phonenum = phonenum;
        this.ticketnum = ticketnum;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhonenum()
    {
        return phonenum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhonenum(String phonenum)
    {
        this.phonenum = phonenum;
    }

    public int getTicketnum()
    {
        return ticketnum;
    }

    public void setTicketnum(int ticketnum) {
        this.ticketnum = ticketnum;
    }

}
