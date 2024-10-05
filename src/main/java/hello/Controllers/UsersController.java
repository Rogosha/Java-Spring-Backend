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

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @GetMapping("/users")
    public Iterable<Users> getUsers() {
        return usersRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @GetMapping("/users/{id}")
    public Optional<Users> getUser(@PathVariable(value = "id") int id) {
        return usersRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/users/verify")
    public Response verifyUser(@RequestBody Users newUser) {
        Response response = new Response();
        Users user = null;
        try{
            user = usersRepository.findByEmail(newUser.getEmail()).orElseThrow();
        } catch (Exception e){
            //USER NOT FOUND
            response.setStatus("NOT FOUND");
            response.setUser(null);
            return null;
        }

        UsersBlocking usersBlocking = null;
        try{
            usersBlocking = usersBlockingRepository.findByUser(user).orElseThrow();
        } catch (Exception _){

        }
        if (user.getPassword().equals(getHash.getH(newUser.getPassword()))) {
            if (usersBlocking == null || usersBlocking.getBlockingReason() == null) {
                response.setUser(user);
                response.setStatus("ACCESS ACCEPT");
                return response;
            } else {
                //ACCESS DENIED
                response.setStatus("user blocking because" + usersBlocking.getBlockingReason());
                response.setUser(user);
                return response;
            }
        } else {
            //INCORRECT PASSWORD
            response.setUser(user);
            response.setStatus("INCORRECT PASSWORD");
            return response;
        }

    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @PostMapping("/users")
    public Users postUser(@RequestBody UsersDTO userDTO) {
        Users user = new Users();
        user.setRole(rolesRepository.findById(userDTO.getRole()).orElseThrow());
        user.setEmail(userDTO.getEmail());
        user.setPassword(getHash.getH(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getFirstName());
        user.setOffice(officesRepository.findById(userDTO.getOffice()).orElseThrow());
        user.setBirthdate(userDTO.getBirthdate());
        user.setActive(userDTO.getActive());
        usersRepository.save(user);
        return user;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
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

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
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
