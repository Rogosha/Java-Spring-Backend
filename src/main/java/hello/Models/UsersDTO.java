package hello.Models;

import java.time.LocalDate;

public class UsersDTO {
    private int id;

    private Integer role;

    private String email;

    private String password;

    private String firstName;

    private String LastName;

    private Integer office;

    private LocalDate birthdate;

    private Boolean active;

    public UsersDTO(int id, Integer role, String email, String password, String firstName, String lastName, Integer office, LocalDate birthdate, Boolean active) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        LastName = lastName;
        this.office = office;
        this.birthdate = birthdate;
        this.active = active;
    }

    public UsersDTO() {
    }

    public int getId() {
        return id;
    }

    public Integer getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public Integer getOffice() {
        return office;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Boolean getActive() {
        return active;
    }
}
