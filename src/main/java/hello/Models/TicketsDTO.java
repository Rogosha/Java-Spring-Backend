package hello.Models;

import jakarta.persistence.*;

public class TicketsDTO {
    private int id;

    private Integer user;

    private Integer schedule;

    private Integer cabinType;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String passportNumber;

    private Integer country;

    private String bookingReference;

    private Boolean confirmed;

    public TicketsDTO(int id, Integer user, Integer schedule, Integer cabinType, String firstName, String lastName, String email, String phone, String passportNumber, Integer country, String bookingReference, Boolean confirmed) {
        this.id = id;
        this.user = user;
        this.schedule = schedule;
        this.cabinType = cabinType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.passportNumber = passportNumber;
        this.country = country;
        this.bookingReference = bookingReference;
        this.confirmed = confirmed;
    }

    public TicketsDTO() {
    }

    public int getId() {
        return id;
    }

    public Integer getUser() {
        return user;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public Integer getCabinType() {
        return cabinType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Integer getCountry() {
        return country;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }
}
