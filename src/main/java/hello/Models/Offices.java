package hello.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="offices")
public class Offices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "CountryID", referencedColumnName = "id", nullable = false)
    private Countries country;

    @OneToMany(mappedBy = "office")
    @JsonIgnore
    private List<Users> users;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @Column(name = "Phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "Contact", length = 250, nullable = false)
    private String contact;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Offices() {
    }

    public Offices(Countries country, String title, String phone, String contact) {
        this.country = country;
        this.title = title;
        this.phone = phone;
        this.contact = contact;
    }
}
