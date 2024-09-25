package hello.Controllers;

import hello.Models.UsersBlocking;
import hello.Repositories.UsersBlockingRepository;
import hello.Response;
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
    public String putCountry(@RequestBody UsersBlocking newUserBlocking) {
        Response response = new Response();
        try {
            UsersBlocking userBlocking = usersBlockingRepository.findById(newUserBlocking.getId()).orElseThrow();
            usersBlockingRepository.save(userBlocking);
            if (newUserBlocking.getUser() != null) {
                userBlocking.setUser(newUserBlocking.getUser());
            }
            if (newUserBlocking.getBlockingReason() != null) {
                userBlocking.setBlockingReason(newUserBlocking.getBlockingReason());
            }
            usersBlockingRepository.save(userBlocking);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/usersblocking/{id}")
    public String deleteCountry(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            UsersBlocking usersBlocking = usersBlockingRepository.findById(id).orElseThrow();
            usersBlockingRepository.delete(usersBlocking);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }
}
