package hello.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="airports")
public class Airports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "CountryID", referencedColumnName = "id", nullable = false)
    private Countries country;

    @Column(name ="IATACode", length = 3, nullable = false)
    private String IATACode;

    @Column(name ="Name", length = 50)
    private String name;

    @OneToMany(mappedBy = "departureAirport")
    @JsonIgnore
    private List<Routes> departureRoutes;

    @OneToMany(mappedBy = "arrivalAirport")
    @JsonIgnore
    private List<Routes> arrivalRoutes;

    public int getId() {
        return id;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Routes> getDepartureRoutes() {
        return departureRoutes;
    }

    public void setDepartureRoutes(List<Routes> departureRoutes) {
        this.departureRoutes = departureRoutes;
    }

    public List<Routes> getArrivalRoutes() {
        return arrivalRoutes;
    }

    public void setArrivalRoutes(List<Routes> arrivalRoutes) {
        this.arrivalRoutes = arrivalRoutes;
    }

    public Airports(Countries country, String IATACode, String name, List<Routes> departureRoutes, List<Routes> arrivalRoutes) {
        this.country = country;
        this.IATACode = IATACode;
        this.name = name;
        this.departureRoutes = departureRoutes;
        this.arrivalRoutes = arrivalRoutes;
    }

    public Airports() {
    }
}
