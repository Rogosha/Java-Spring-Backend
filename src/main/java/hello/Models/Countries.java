package hello.Models;

import jakarta.persistence.*;

@Entity
@Table(name="countries")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="Name", length = 50, columnDefinition = "COLLATE utf8_bin", nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Countries(String name) {
        this.name = name;
    }

    public Countries() {
    }
}
