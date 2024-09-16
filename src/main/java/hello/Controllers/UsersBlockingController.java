package hello.Controllers;

import hello.Models.UsersBlocking;
import hello.Repositories.UsersBlockingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersBlockingController {
    @Autowired
    private UsersBlockingRepository usersBlockingRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/usersblocking")
    public Iterable<UsersBlocking> getCountries() {
        return usersBlockingRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/usersblocking/{id}")
    public Optional<UsersBlocking> getCountry(@PathVariable(value = "id") int id) {
        return usersBlockingRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/usersblocking")
    public Integer postCountry(@RequestBody UsersBlocking usersBlocking) {
        usersBlockingRepository.save(usersBlocking);
        return usersBlocking.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/usersblocking/{id}")
    public String putCountry(@RequestBody UsersBlocking usersBlocking) {
        try {
            usersBlockingRepository.save(usersBlocking);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/usersblocking/{id}")
    public String deleteCountry(
            @PathVariable(value = "id") int id) {
        try {
            UsersBlocking usersBlocking = usersBlockingRepository.findById(id).orElseThrow();
            usersBlockingRepository.delete(usersBlocking);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }
}
