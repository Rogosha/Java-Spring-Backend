package hello.Models;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

public class SchedulesDTO {
    private int id;

    private LocalDate date;

    private LocalTime time;

    private Integer aircraft;

    private Integer route;

    private String flightNumber;

    private Double economyPrice;

    private Boolean confirmed;

    public SchedulesDTO(int id, LocalDate date, LocalTime time, Integer aircraft, Integer route, String flightNumber, Double economyPrice, Boolean confirmed) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.aircraft = aircraft;
        this.route = route;
        this.flightNumber = flightNumber;
        this.economyPrice = economyPrice;
        this.confirmed = confirmed;
    }

    public SchedulesDTO() {
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Integer getAircraft() {
        return aircraft;
    }

    public Integer getRoute() {
        return route;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Double getEconomyPrice() {
        return economyPrice;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }
}
