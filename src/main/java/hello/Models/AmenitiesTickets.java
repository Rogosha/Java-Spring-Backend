package hello.Models;

import hello.Models.EmbeddedIds.AmenityTicketsId;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="amenitiestickets")
public class AmenitiesTickets {

    @EmbeddedId
    private AmenityTicketsId amenityTicketsId;

    @ManyToOne
    @MapsId("amenityId")
    @JoinColumn(name = "AmenityID", nullable = false)
    private Amenities amenities;

    @ManyToOne
    @MapsId("ticketsId")
    @JoinColumn(name = "TicketID", nullable = false)
    private Tickets tickets;

    @Column(name = "Price", nullable = false, columnDefinition = "0")
    private Double price;

    public AmenitiesTickets(Amenities amenities, Tickets tickets, Double price) {
        this.amenities = amenities;
        this.tickets = tickets;
        this.price = price;
    }

    public AmenitiesTickets() {
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
