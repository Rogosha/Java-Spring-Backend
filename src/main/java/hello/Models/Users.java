package hello.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="RoleID", nullable = false)
    private Integer roleId;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(name="Firstname", nullable = true, length = 50)
    private String firstName;

    @Column(name="Lastname", nullable = false, length = 50)
    private String lastName;

    @Column(name="OfficeID", nullable = true)
    private int officeId;

    @Column(nullable = true)
    private LocalDate birthdate;

    @Column(name="Active", nullable = true)
    private Boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
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

    public Users(Integer roleId,
                 String email,
                 String password,
                 String firstName,
                 String lastName,
                 int officeId,
                 LocalDate birthdate,
                 Boolean active) {
        this.roleId = roleId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeId = officeId;
        this.birthdate = birthdate;
        this.active = active;
    }

    public Users(int id, Integer roleId, String email, String password, String firstName, String lastName, int officeId, LocalDate birthdate, Boolean active) {
        this.id = id;
        this.roleId = roleId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeId = officeId;
        this.birthdate = birthdate;
        this.active = active;
    }

    public Users() {
    }
}
