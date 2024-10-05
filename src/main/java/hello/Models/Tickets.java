package hello.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "ScheduleID", referencedColumnName = "id", nullable = false)
    private Schedules schedule;

    @ManyToOne
    @JoinColumn(name = "CabintypeID", referencedColumnName = "id", nullable = false)
    private CabinTypes cabinType;

    @Column(name = "Firstname", length = 50, nullable = false)
    private String firstName;

    @Column(name = "Lastname", length = 50, nullable = false)
    private String lastName;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Phone", length = 14, nullable = false)
    private String phone;

    @Column(name = "Passportnumber", length = 9, nullable = false)
    private String passportNumber;

    @ManyToOne
    @JoinColumn(name = "PassportcountryID", referencedColumnName = "id", nullable = false)
    private Countries country;

    @Column(name = "Bookingreference", length = 6, nullable = false)
    private String bookingReference;

    @Column(name = "Confirmed", nullable = false)
    private Boolean confirmed;

    public Tickets(Users user, Schedules schedule, CabinTypes cabinType, String firstName, String lastName, String email, String phone, String passportNumber, Countries country, String bookingReference, Boolean confirmed) {
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

    public Tickets() {
    }

    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Schedules getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedules schedule) {
        this.schedule = schedule;
    }

    public CabinTypes getCabinType() {
        return cabinType;
    }

    public void setCabinType(CabinTypes cabinType) {
        this.cabinType = cabinType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }
}
