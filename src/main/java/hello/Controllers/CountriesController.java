package hello.Controllers;

import hello.Models.Countries;
import hello.Repositories.CountriesRepository;
import hello.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CountriesController {

    @Autowired
    private CountriesRepository countriesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/countries")
    public Iterable<Countries> getCountries() {
        return countriesRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/countries/{id}")
    public Optional<Countries> getCountry(@PathVariable(value = "id") int id) {
        return countriesRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/countries")
    public Integer postCountry(@RequestBody Countries country) {
        countriesRepository.save(country);
        return country.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/countries")
    public String putCountry(@RequestBody Countries newCountry) {
        Response response = new Response();
        try {
            Countries country = countriesRepository.findById(newCountry.getId()).orElseThrow();
            if (newCountry.getName() != null) {
                country.setName(newCountry.getName());
            }
            countriesRepository.save(country);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/countries/{id}")
    public String deleteCountry(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            Countries country = countriesRepository.findById(id).orElseThrow();
            countriesRepository.delete(country);
            response.setStatus("OK");
            return response.getStatus();
        } catch (Exception e) {
            response.setStatus("NOT_OK");
            return response.getStatus();
        }
    }
}
