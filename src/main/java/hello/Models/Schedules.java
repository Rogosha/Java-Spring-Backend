package hello.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "schedules")
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "Time", nullable = false)
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "AircraftID", nullable = false)
    private Aircrafts aircraft;

    @ManyToOne
    @JoinColumn(name = "RouteID", nullable = false)
    private Routes route;

    @Column(name = "Flightnumber", length = 10)
    private String flightNumber;

    @Column(name = "Economyprice", nullable = false)
    private Double economyPrice;

    @Column(name = "Confirmed", nullable = false)
    private Boolean confirmed;

    @OneToMany(mappedBy = "schedule")
    @JsonIgnore
    private List<Tickets> tickets;

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }

    public Routes getRoute() {
        return route;
    }

    public void setRoute(Routes route) {
        this.route = route;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(Double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }



    public Schedules(LocalDate date, LocalTime time, Aircrafts aircraft, Routes route, String flightNumber, Double economyPrice, Boolean confirmed) {
        this.date = date;
        this.time = time;
        this.aircraft = aircraft;
        this.route = route;
        this.flightNumber = flightNumber;
        this.economyPrice = economyPrice;
        this.confirmed = confirmed;
    }

    public Schedules() {
    }

}
