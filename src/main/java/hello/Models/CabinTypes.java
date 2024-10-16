package hello.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cabintypes")
public class CabinTypes {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "cabinType")
    @JsonIgnore
    private List<Tickets> tickets;

    @OneToMany(mappedBy = "cabinType")
    @JsonIgnore
    private List<Surveys> surveys;

    @OneToMany(mappedBy = "cabinType")
    @JsonIgnore
    private List<AmenitiesCabinType> amenitiesCabinTypes ;

    public CabinTypes(String name, List<Tickets> tickets) {
        this.name = name;
        this.tickets = tickets;
    }

    public CabinTypes() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
