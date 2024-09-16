package hello.Controllers;

import hello.Models.Users;
import hello.Models.UsersInfo;
import hello.Other.ArrayOf;
import hello.Repositories.OfficesRepository;
import hello.Repositories.RolesRepository;
import hello.Repositories.UsersInfoRepository;
import hello.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hello.Other.getHash;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OfficesRepository officesRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UsersInfoRepository usersInfoRepository;

    @GetMapping("/users")
    public Iterable<Users> getUsers() {
        Iterable<Users> users = usersRepository.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getUser(@PathVariable(value = "id") int id) {
        Optional<Users> user = usersRepository.findById(id);
        return user;
    }

    @GetMapping("/users/verify")
    public String verifyUser(@RequestParam(name = "Email") String email, @RequestParam(name = "Password") String password){
        Users[] users = ArrayOf.Users(usersRepository.findAll());
        Users user = null;
        for (Users userTemp : users ){
            if (userTemp.getEmail().equals(email)) user = userTemp;
        }

        UsersInfo[] usersInfos = ArrayOf.UsersInfo(usersInfoRepository.findAll());
        UsersInfo userInfo = null;
        for (UsersInfo userInfoTemp : usersInfos ){
            if (userInfoTemp.getUser() == user){
                userInfo = userInfoTemp;
            }
        }

        if (user != null){
            if (getHash.getH(password).equals(user.getPassword())){
                if (userInfo == null || userInfo.getBlockingReason() == null){
                    return "ACCESS ACCEPT";
                } else {
                    return "ACCESS DENIED: " + userInfo.getBlockingReason();
                }
            } else {
                return "INCORRECT PASSWORD";
            }
        } else {
            return "USER NOT FOUND";
        }
    }

    @PostMapping("/users")
    public Integer postUser(
            @RequestParam(name = "RoleID") Integer roleID,
            @RequestParam(name = "Email") String email,
            @RequestParam(name = "Password") String password,
            @RequestParam(name = "FirstName") String firstName,
            @RequestParam(name = "LastName") String lastName,
            @RequestParam(name = "OfficeID") int officeId,
            @RequestParam(name = "Birthdate") String birth,
            @RequestParam(name = "Active") boolean active) {
        String[] date = birth.split("-");
        LocalDate birthdate = LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        Users user;
            user = new Users(rolesRepository.findById(roleID).orElseThrow(), email, getHash.getH(password), firstName, lastName, officesRepository.findById(officeId).orElseThrow(), birthdate, active);
        usersRepository.save(user);
        return user.getId();
    }

    @PutMapping("/users/{id}")
    public String putUser(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "RoleID", required = false) Integer roleID,
            @RequestParam(name = "Email", required = false) String email,
            @RequestParam(name = "Password", required = false) String password,
            @RequestParam(name = "FirstName", required = false) String firstName,
            @RequestParam(name = "LastName", required = false) String lastName,
            @RequestParam(name = "OfficeID", required = false) Integer officeId,
            @RequestParam(name = "Birthdate", required = false) String birthDateString,
            @RequestParam(name = "Active", required = false) Boolean active) {
        LocalDate birthdate = null;
        /*
        if (birth != null) {
            String[] date = birth.split("-");
            birthdate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
        }*/
        try {
            Users user = usersRepository.findById(id).orElseThrow();
            if (birthDateString != null) {
                birthdate = LocalDate.parse(birthDateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } else {
                birthdate = user.getBirthdate();
            }
            if (roleID == null) {
                roleID = user.getRole().getId();
            }
            if (email == null) {
                 email = user.getEmail();
            }
            if (password == null) {
                password = user.getPassword();
            } else {
                password = getHash.getH(password);
            }
            if (firstName == null) {
                firstName = user.getFirstName();
            }
            if (lastName == null) {
                lastName = user.getLastName();
            }
            if (officeId == null) {
                officeId = user.getOffice().getId();
            }
           /* if (birthdate == null) {
                birthdate = user.getBirthdate();
            } */
            if (active == null) {
                active = user.getActive();
            }
            user.setRole(rolesRepository.findById(roleID).orElseThrow());
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setOffice(officesRepository.findById(officeId).orElseThrow());
            user.setBirthdate(birthdate);
            user.setActive(active);
            usersRepository.save(user);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(
            @PathVariable(value = "id") int id) {
        try {
            Users user = usersRepository.findById(id).orElseThrow();
            usersRepository.delete(user);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }
}
