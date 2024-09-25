package hello.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<Users> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Roles(String title) {
        this.title = title;
    }

    public Roles() {
    }
}
