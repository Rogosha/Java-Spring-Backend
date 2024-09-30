package hello.Controllers;

import hello.Models.Countries;
import hello.Repositories.CountriesRepository;
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
    public Countries postCountry(@RequestBody Countries country) {
        countriesRepository.save(country);
        return country;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/countries")
    public Countries putCountry(@RequestBody Countries newCountry) {
        try {
            Countries country = countriesRepository.findById(newCountry.getId()).orElseThrow();
            if (newCountry.getName() != null) {
                country.setName(newCountry.getName());
            }
            countriesRepository.save(country);
            return country;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/countries/{id}")
    public Countries deleteCountry(@PathVariable(value = "id") int id) {
        try {
            Countries country = countriesRepository.findById(id).orElseThrow();
            countriesRepository.delete(country);
            return country;
        } catch (Exception e) {
            return null;
        }
    }
}
