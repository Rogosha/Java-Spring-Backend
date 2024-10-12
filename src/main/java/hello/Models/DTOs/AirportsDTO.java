package hello.Models.DTOs;

public class AirportsDTO {
    private int id;

    private Integer country;

    private String iatacode;

    private String name;

    public AirportsDTO() {
        this.id = 0;
    }

    public AirportsDTO(int id, int country, String IATACode, String name) {
        this.id = id;
        this.country = country;
        this.iatacode = IATACode;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Integer getCountry() {
        return country;
    }

    public String getIatacode() {
        return iatacode;
    }

    public String getName() {
        return name;
    }
}
