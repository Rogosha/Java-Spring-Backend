package hello.Models.DTOs;

public class RoutesDTO {
    private int id;

    private Integer departureAirport;

    private Integer arrivalAirport;

    private Integer distance;

    private Integer flightTime;

    public RoutesDTO(int id, Integer departureAirport, Integer arrivalAirport, Integer distance, Integer flightTime) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.distance = distance;
        this.flightTime = flightTime;
    }

    public RoutesDTO() {
    }

    public int getId() {
        return id;
    }

    public Integer getDepartureAirport() {
        return departureAirport;
    }

    public Integer getArrivalAirport() {
        return arrivalAirport;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getFlightTime() {
        return flightTime;
    }
}
