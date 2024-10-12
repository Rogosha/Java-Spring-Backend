package hello.Controllers;

import hello.Models.UsersBlocking;
import hello.Models.DTOs.UsersBlockingDTO;
import hello.Repositories.UsersBlockingRepository;
import hello.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersBlockingController {
    @Autowired
    private UsersBlockingRepository usersBlockingRepository;

    @Autowired
    private UsersRepository usersRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @GetMapping("/usersblocking")
    public Iterable<UsersBlocking> getCountries() {
        return usersBlockingRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @GetMapping("/usersblocking/{id}")
    public Optional<UsersBlocking> getCountry(@PathVariable(value = "id") int id) {
        return usersBlockingRepository.findByUser(usersRepository.findById(id).orElseThrow());
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/usersblocking")
    public UsersBlocking postCountry(@RequestBody UsersBlockingDTO usersBlockingDTO) {
        UsersBlocking usersBlocking = new UsersBlocking();
        usersBlocking.setBlockingReason(usersBlockingDTO.getBlockingReason());
        usersBlocking.setUser(usersRepository.findById(usersBlockingDTO.getUser()).orElseThrow());


        usersBlockingRepository.save(usersBlocking);
        return usersBlocking;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @PutMapping("/usersblocking")
    public UsersBlocking putCountry(@RequestBody UsersBlockingDTO userBlockingDTO) {
        try {
            UsersBlocking userBlocking = usersBlockingRepository.findById(userBlockingDTO.getId()).orElseThrow();
            if (userBlockingDTO.getUser() != null) {
                userBlocking.setUser(usersRepository.findById(userBlockingDTO.getUser()).orElseThrow());
            }
            if (userBlockingDTO.getBlockingReason() != null) {
                userBlocking.setBlockingReason(userBlockingDTO.getBlockingReason());
            }
            usersBlockingRepository.save(userBlocking);
            return userBlocking;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.OPTIONS})
    @DeleteMapping("/usersblocking/{id}")
    public UsersBlocking deleteCountry(@PathVariable(value = "id") int id) {
        try {
            UsersBlocking usersBlocking = usersBlockingRepository.findById(id).orElseThrow();
            usersBlockingRepository.delete(usersBlocking);
            return usersBlocking;
        } catch (Exception e) {
            return null;
        }
    }
}
