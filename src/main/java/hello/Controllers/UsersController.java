package hello.Controllers;

import hello.Models.Users;
import hello.Models.UsersBlocking;
import hello.Other.ArrayOf;
import hello.Repositories.UsersBlockingRepository;
import hello.Repositories.UsersRepository;
import hello.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hello.Other.getHash;

import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersBlockingRepository usersBlockingRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/users")
    public Iterable<Users> getUsers() {
        return usersRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/users/{id}")
    public Optional<Users> getUser(@PathVariable(value = "id") int id) {
        return usersRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/users/verify")
    public Response verifyUser(@RequestBody Users newUser) {
        Users[] users = ArrayOf.Users(usersRepository.findAll());
        Users user = null;
        for (Users userTemp : users) {
            if (userTemp.getEmail().equals(newUser.getEmail())) user = userTemp;
        }

        UsersBlocking[] usersBlockings = ArrayOf.UsersBlocking(usersBlockingRepository.findAll());
        UsersBlocking usersBlocking = null;
        for (UsersBlocking userBlockingTemp : usersBlockings) {
            if (userBlockingTemp.getUser() == user) {
                usersBlocking = userBlockingTemp;
            }
        }

        Response response = new Response();
        if (user != null) {
            if (user.getPassword().equals(getHash.getH(newUser.getPassword()))) {
                if (usersBlocking == null || usersBlocking.getBlockingReason() == null) {
                    response.setStatus("ACCESS ACCEPT");
                    return response;
                } else {
                    response.setStatus("ACCESS DENIED: " + usersBlocking.getBlockingReason());
                    return response;
                }
            } else {
                response.setStatus("INCORRECT PASSWORD");
                return response;
            }
        } else {
            response.setStatus("USER NOT FOUND");
            return response;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/users")
    public Integer postUser(@RequestBody Users user) {
        usersRepository.save(user);
        return user.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/users")
    public String putUser(@RequestBody Users newUser) {
        try {
            Users user = usersRepository.findById(newUser.getId()).orElseThrow();

            if (newUser.getRole() != null) {
                user.setRole(newUser.getRole());
            }
            if (newUser.getEmail() != null) {
                user.setEmail(newUser.getEmail());
            }
            if (newUser.getPassword() != null) {
                user.setPassword(getHash.getH(newUser.getPassword()));
            }
            if (newUser.getFirstName() != null) {
                user.setFirstName(newUser.getFirstName());
            }
            if (newUser.getLastName() != null) {
                user.setLastName(newUser.getLastName());
            }
            if (newUser.getOffice() != null) {
                user.setOffice(newUser.getOffice());
            }
            if (newUser.getBirthdate() != null) {
                user.setBirthdate(newUser.getBirthdate());
            }
            if (newUser.getActive() != null) {
                user.setActive(newUser.getActive());
            }
            usersRepository.save(user);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        try {
            Users user = usersRepository.findById(id).orElseThrow();
            usersRepository.delete(user);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }
}
