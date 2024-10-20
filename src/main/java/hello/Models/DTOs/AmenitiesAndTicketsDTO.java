package hello.Models.DTOs;

import hello.Models.AmenitiesTickets;
import hello.Models.Tickets;

import java.util.Deque;

public class AmenitiesAndTicketsDTO {
    Tickets tickets;
    Deque<AmenitiesTickets> amenitiesTickets;

    public AmenitiesAndTicketsDTO(Tickets tickets, Deque<AmenitiesTickets> amenitiesTickets) {
        this.tickets = tickets;
        this.amenitiesTickets = amenitiesTickets;
    }

    public AmenitiesAndTicketsDTO() {
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public Deque<AmenitiesTickets> getAmenitiesTickets() {
        return amenitiesTickets;
    }

    public void setAmenitiesTickets(Deque<AmenitiesTickets> amenitiesTickets) {
        this.amenitiesTickets = amenitiesTickets;
    }
}
