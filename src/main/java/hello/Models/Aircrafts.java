package hello.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "aircrafts")
public class Aircrafts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "Makemodel", length = 10)
    private String makeModel;

    @Column(name = "Totalseats", nullable = false)
    private Integer totalSeats;

    @Column(name = "Businessseats", nullable = false)
    private Integer businessSeats;

    @Column(name = "Economyseats", nullable = false)
    private Integer economySeats;

    @OneToMany(mappedBy = "aircraft")
    @JsonIgnore
    private List<Schedules> schedules;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(Integer businessSeats) {
        this.businessSeats = businessSeats;
    }

    public Integer getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public List<Schedules> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedules> schedules) {
        this.schedules = schedules;
    }

    public Aircrafts(String name, String makeModel, Integer totalSeats, Integer businessSeats, int economySeats, List<Schedules> schedules) {
        this.name = name;
        this.makeModel = makeModel;
        this.totalSeats = totalSeats;
        this.businessSeats = businessSeats;
        this.economySeats = economySeats;
        this.schedules = schedules;
    }

    public Aircrafts() {
    }
}
