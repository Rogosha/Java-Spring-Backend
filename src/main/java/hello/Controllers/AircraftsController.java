package hello.Controllers;

import hello.Models.Aircrafts;
import hello.Models.Users;
import hello.Other.getHash;
import hello.Repositories.AircraftsRepository;
import hello.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AircraftsController {

    @Autowired
    private AircraftsRepository aircraftsRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/aircrafts")
    public Iterable<Aircrafts> getAircrafts() {
        return aircraftsRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/aircrafts/{id}")
    public Optional<Aircrafts> getAircraft(@PathVariable(value = "id") int id) {
        return aircraftsRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/aircrafts")
    public Integer postAircraft(@RequestBody Aircrafts aircraft) {
        aircraftsRepository.save(aircraft);
        return aircraft.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/aircrafts")
    public String putAircraft(@RequestBody Aircrafts newAircraft) {
        Response response = new Response();
        try {
            Aircrafts aircraft = aircraftsRepository.findById(newAircraft.getId()).orElseThrow();

            if (newAircraft.getName() != null) {
                aircraft.setName(newAircraft.getName());
            }
            if (newAircraft.getMakeModel() != null) {
                aircraft.setMakeModel(newAircraft.getMakeModel());
            }
            if (newAircraft.getTotalSeats() != null) {
                aircraft.setTotalSeats(newAircraft.getTotalSeats());
            }
            if (newAircraft.getBusinessSeats() != null) {
                aircraft.setBusinessSeats(newAircraft.getBusinessSeats());
            }
            if (newAircraft.getEconomySeats() != null) {
                aircraft.setEconomySeats(newAircraft.getEconomySeats());
            }
            aircraftsRepository.save(aircraft);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/aircrafts/{id}")
    public String deleteAircraft(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            Aircrafts aircraft = aircraftsRepository.findById(id).orElseThrow();
            aircraftsRepository.delete(aircraft);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }
}
