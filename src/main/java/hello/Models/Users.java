package hello.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="RoleID", nullable = false)
    private Roles role;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UsersLogs> userLogs;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private UsersBlocking userBlocking;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name="Firstname", length = 50)
    private String firstName;

    @Column(name="Lastname", nullable = false, length = 50)
    private String lastName;

    @ManyToOne
    @JoinColumn(name="OfficeID")
    private Offices office;

    @Column
    private LocalDate birthdate;

    @Column(name="Active")
    private Boolean active;

    public int getId() {
        return id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Offices getOffice() {
        return office;
    }

    public void setOffice(Offices office) {
        this.office = office;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Users(Roles role, String email, String password, String firstName, String lastName, Offices office, LocalDate birthdate, Boolean active) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.office = office;
        this.birthdate = birthdate;
        this.active = active;
    }

    public Users() {
    }
}
