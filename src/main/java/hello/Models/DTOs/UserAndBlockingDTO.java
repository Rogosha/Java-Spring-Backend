package hello.Models.DTOs;

import hello.Models.Offices;
import hello.Models.Roles;
import hello.Models.Users;
import hello.Models.UsersBlocking;

import java.time.LocalDate;

public class UserAndBlockingDTO {
    private int id;

    private Roles role;

    private UsersBlocking userBlocking;

    private String email;

    private String firstName;

    private String lastName;

    private Offices office;

    private LocalDate birthdate;

    private Boolean active;

    public void userSetter(Users users){
        this.id = users.getId();
        this.role = users.getRole();
        this.email = users.getEmail();
        this.firstName = users.getFirstName();
        this.lastName = users.getLastName();
        this.office = users.getOffice();
        this.birthdate = users.getBirthdate();
        this.active = users.getActive();
    }

    public UserAndBlockingDTO(Roles role, UsersBlocking userBlocking, String email, String firstName, String lastName, Offices office, LocalDate birthdate, Boolean active) {
        this.role = role;
        this.userBlocking = userBlocking;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.office = office;
        this.birthdate = birthdate;
        this.active = active;
    }

    public UserAndBlockingDTO() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public UsersBlocking getUserBlocking() {
        return userBlocking;
    }

    public void setUserBlocking(UsersBlocking userBlocking) {
        this.userBlocking = userBlocking;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Offices getOffice() {
        return office;
    }

    public void setOffice(Offices office) {
        this.office = office;
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
}
