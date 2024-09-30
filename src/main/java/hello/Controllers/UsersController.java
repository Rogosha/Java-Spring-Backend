package hello.Controllers;

import hello.Models.Users;
import hello.Models.UsersBlocking;
import hello.Models.UsersDTO;
import hello.Other.ArrayOf;
import hello.Repositories.OfficesRepository;
import hello.Repositories.RolesRepository;
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

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private OfficesRepository officesRepository;


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
    public Users postUser(@RequestBody UsersDTO userDTO) {
        Users user = new Users();
        user.setRole(rolesRepository.findById(userDTO.getRole()).orElseThrow());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getFirstName());
        user.setOffice(officesRepository.findById(userDTO.getOffice()).orElseThrow());
        user.setBirthdate(userDTO.getBirthdate());
        user.setActive(userDTO.getActive());
        usersRepository.save(user);
        return user;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/users")
    public Users putUser(@RequestBody UsersDTO userDTO) {
        try {
            Users user = usersRepository.findById(userDTO.getId()).orElseThrow();

            if (userDTO.getRole() != null) {
                user.setRole(rolesRepository.findById(userDTO.getRole()).orElseThrow());
            }
            if (userDTO.getEmail() != null) {
                user.setEmail(userDTO.getEmail());
            }
            if (userDTO.getPassword() != null) {
                user.setPassword(getHash.getH(userDTO.getPassword()));
            }
            if (userDTO.getFirstName() != null) {
                user.setFirstName(userDTO.getFirstName());
            }
            if (userDTO.getLastName() != null) {
                user.setLastName(userDTO.getLastName());
            }
            if (userDTO.getOffice() != null) {
                user.setOffice(officesRepository.findById(userDTO.getOffice()).orElseThrow());
            }
            if (userDTO.getBirthdate() != null) {
                user.setBirthdate(userDTO.getBirthdate());
            }
            if (userDTO.getActive() != null) {
                user.setActive(userDTO.getActive());
            }
            usersRepository.save(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/users/{id}")
    public Users deleteUser(@PathVariable(value = "id") int id) {
        try {
            Users user = usersRepository.findById(id).orElseThrow();
            usersRepository.delete(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
