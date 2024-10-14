package hello.Models.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

public class SchedulesUpdateDTO {

    private String action;

    private LocalDate date;

    private LocalTime time;

    private String departureAirport;

    private String arrivalAirport;

    private String flightNumber;

    private Integer aircraft;

    private Double economyPrice;

    private String confirmed;

    public SchedulesUpdateDTO(String action, LocalDate date, LocalTime time, String departureAirport, String arrivalAirport, String flightNumber, Integer aircraft, Double economyPrice, String confirmed) {
        this.action = action;
        this.date = date;
        this.time = time;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.economyPrice = economyPrice;
        this.confirmed = confirmed;
    }

    public SchedulesUpdateDTO() {
    }

    public String getAction() {
        return action;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Integer getAircraft() {
        return aircraft;
    }

    public Double getEconomyPrice() {
        return economyPrice;
    }

    public String getConfirmed() {
        return confirmed;
    }
}
