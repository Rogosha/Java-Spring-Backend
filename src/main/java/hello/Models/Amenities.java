package hello.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "amenities")
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Service", length = 50, nullable = false)
    private String service;

    @Column(name = "Price", length = 50, nullable = false)
    private Double price;


    @OneToMany(mappedBy = "amenities")
    @JsonIgnore
    private List<AmenitiesTickets> amenitiesTickets;

    @OneToMany(mappedBy = "amenities")
    @JsonIgnore
    private List<AmenitiesCabinType> amenitiesCabinTypes;

    public Amenities(String service, Double price) {
        this.service = service;
        this.price = price;
    }



    public Amenities() {
    }

    public int getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
