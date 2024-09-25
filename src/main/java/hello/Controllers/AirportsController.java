package hello.Controllers;

import hello.Models.Airports;
import hello.Repositories.AirportsRepository;
import hello.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AirportsController {
    @Autowired
    private AirportsRepository airportsRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/airports")
    public Iterable<Airports> getAirports() {
        return airportsRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/airports/{id}")
    public Optional<Airports> getAirport(@PathVariable(value = "id") int id) {
        return airportsRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/airports")
    public Integer postAirport(@RequestBody Airports airport) {
        airportsRepository.save(airport);
        return airport.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/airports")
    public String putAirport(@RequestBody Airports newAirport) {
        Response response = new Response();
        try {
            Airports airports = airportsRepository.findById(newAirport.getId()).orElseThrow();
            if (newAirport.getCountry() != null) {
                airports.setCountry(newAirport.getCountry());
            }
            if (newAirport.getIATACode() != null) {
                airports.setIATACode(newAirport.getIATACode());
            }
            if (newAirport.getName() != null) {
                airports.setName(newAirport.getName());
            }
            airportsRepository.save(airports);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/airports/{id}")
    public String deleteAirport(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            Airports airport = airportsRepository.findById(id).orElseThrow();
            airportsRepository.delete(airport);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }
}
