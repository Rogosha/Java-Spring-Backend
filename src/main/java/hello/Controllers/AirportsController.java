package hello.Controllers;

import hello.Models.Airports;
import hello.Models.DTOs.AirportsDTO;
import hello.Repositories.AirportsRepository;
import hello.Repositories.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AirportsController {
    @Autowired
    private AirportsRepository airportsRepository;

    @Autowired
    private CountriesRepository countriesRepository;


    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/airports")
    public Iterable<Airports> getAirports() {
        return airportsRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/airports/{id}")
    public Optional<Airports> getAirport(@PathVariable(value = "id") int id) {
        return airportsRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/airports")
    public Airports postAirport(@RequestBody AirportsDTO airportDTO) {
        Airports airport = new Airports();
        airport.setName(airportDTO.getName());
        airport.setCountry(countriesRepository.findById(airportDTO.getCountry()).orElseThrow());
        airport.setIATACode(airportDTO.getIatacode());
        airportsRepository.save(airport);
        return airport;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/airports")
    public Airports putAirport(@RequestBody AirportsDTO airportDTO) {
        try {
            Airports airport = airportsRepository.findById(airportDTO.getId()).orElseThrow();
            if (airportDTO.getCountry() != null) {
                airport.setCountry(countriesRepository.findById(airportDTO.getCountry()).orElseThrow());
            }
            if (airportDTO.getIatacode() != null) {
                airport.setIATACode(airportDTO.getIatacode());
            }
            if (airportDTO.getName() != null) {
                airport.setName(airportDTO.getName());
            }
            airportsRepository.save(airport);
            return airport;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/airports/{id}")
    public Airports deleteAirport(@PathVariable(value = "id") int id) {
        try {
            Airports airport = airportsRepository.findById(id).orElseThrow();
            airportsRepository.delete(airport);
            return airport;
        } catch (Exception e) {
            return null;
        }
    }
}
