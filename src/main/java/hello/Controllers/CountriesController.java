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

    @GetMapping("/countries")
    public Iterable<Countries> getCountries() {
        Iterable<Countries> countries = countriesRepository.findAll();
        return countries;
    }

    @GetMapping("/countries/{id}")
    public Optional<Countries> getCountry(@PathVariable(value = "id") int id) {
        return countriesRepository.findById(id);
    }

    @PostMapping("/countries")
    public Integer postCountry(@RequestParam(name = "Name") String name) {
        Countries country = new Countries(name);
        countriesRepository.save(country);
        return country.getId();
    }

    @PutMapping("/countries/{id}")
    public String putCountry(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "Name", required = false) String name) {
        try {
            Countries country = countriesRepository.findById(id).orElseThrow();
            if (name == null) {
                name = country.getName();
            }
            country.setName(name);
            countriesRepository.save(country);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }

    @DeleteMapping("/countries/{id}")
    public String deleteCountry(
            @PathVariable(value = "id") int id) {
        try {
            Countries country = countriesRepository.findById(id).orElseThrow();
            countriesRepository.delete(country);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }
}
