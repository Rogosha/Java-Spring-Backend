package hello.Models;

import jakarta.persistence.*;

@Entity
@Table(name="offices")
public class Offices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CountryID", nullable = false)
    private int countryId;

    @Column(name = "Title", length = 50, columnDefinition = "COLLATE utf8_bin", nullable = false)
    private String title;

    @Column(name = "Phone", length = 50, columnDefinition = "COLLATE utf8_bin", nullable = false)
    private String phone;

    @Column(name = "Contact", length = 250, columnDefinition = "COLLATE utf8_bin", nullable = false)
    private String contact;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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

    public Offices(int countryId, String title, String phone, String contact) {
        this.countryId = countryId;
        this.title = title;
        this.phone = phone;
        this.contact = contact;
    }
}
