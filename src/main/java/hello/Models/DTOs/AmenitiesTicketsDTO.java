package hello.Models.DTOs;

import hello.Models.Amenities;

public class AmenitiesTicketsDTO {

        private Integer amenities;

        private Integer tickets;

        private Double price;

    public AmenitiesTicketsDTO(Integer amenities, Integer tickets, Double price) {
        this.amenities = amenities;
        this.tickets = tickets;
        this.price = price;
    }

    public AmenitiesTicketsDTO() {
    }

    public Integer getAmenities() {
        return amenities;
    }

    public void setAmenities(Integer amenities) {
        this.amenities = amenities;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

