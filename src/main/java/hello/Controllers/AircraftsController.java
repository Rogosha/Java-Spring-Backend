package hello.Controllers;

import hello.Models.Aircrafts;
import hello.Repositories.AircraftsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AircraftsController {

    @Autowired
    private AircraftsRepository aircraftsRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/aircrafts")
    public Iterable<Aircrafts> getAircrafts() {
        return aircraftsRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/aircrafts/{id}")
    public Optional<Aircrafts> getAircraft(@PathVariable(value = "id") int id) {
        return aircraftsRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/aircrafts")
    public Aircrafts postAircraft(@RequestBody Aircrafts aircraft) {
        aircraftsRepository.save(aircraft);
        return aircraft;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/aircrafts")
    public Aircrafts putAircraft(@RequestBody Aircrafts newAircraft) {
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
            return aircraft;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/aircrafts/{id}")
    public Aircrafts deleteAircraft(@PathVariable(value = "id") int id) {
        try {
            Aircrafts aircraft = aircraftsRepository.findById(id).orElseThrow();
            aircraftsRepository.delete(aircraft);
            return aircraft;
        } catch (Exception e) {
            return null;
        }
    }
}
