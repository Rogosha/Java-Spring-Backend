package hello.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "routes")
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "DepartureairportID", referencedColumnName = "ID", nullable = false)
    private Airports departureAirport;

    @ManyToOne
    @JoinColumn(name = "ArrivalairportID", referencedColumnName = "ID", nullable = false)
    private Airports arrivalAirport;

    @Column(name = "Distance", nullable = false)
    private Integer distance;

    @Column(name = "Flighttime", nullable = false)
    private Integer flightTime;

    @OneToMany(mappedBy = "route")
    @JsonIgnore
    private List<Schedules> schedules;

    public int getId() {
        return id;
    }

    public Airports getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airports departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airports getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airports arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
    }

    public List<Schedules> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedules> schedules) {
        this.schedules = schedules;
    }

    public Routes(Airports departureAirport, Airports arrivalAirport, Integer distance, Integer flightTime, List<Schedules> schedules) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.distance = distance;
        this.flightTime = flightTime;
        this.schedules = schedules;
    }

    public Routes() {
    }
}
