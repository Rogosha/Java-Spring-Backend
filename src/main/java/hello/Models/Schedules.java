package hello.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="schedules")
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Time")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "AircraftID")
    private Aircrafts aircraft;

    @ManyToOne
    @JoinColumn(name = "RouteID")
    private Routes route;

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

    public Schedules(LocalDate date, LocalTime time, Aircrafts aircraft, Routes route) {
        this.date = date;
        this.time = time;
        this.aircraft = aircraft;
        this.route = route;
    }

    public Schedules() {
    }
}
