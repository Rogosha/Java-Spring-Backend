package hello.Controllers;

import hello.Models.Offices;
import hello.Repositories.CountriesRepository;
import hello.Repositories.OfficesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class OfficesController {

    @Autowired
    private OfficesRepository officesRepository;

    @Autowired
    private CountriesRepository countriesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/offices")
    public Iterable<Offices> getOffices() {
        Iterable<Offices> offices = officesRepository.findAll();
        return offices;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/offices/{id}")
    public Optional<Offices> getOffice(@PathVariable(value = "id") int id) {
        Optional<Offices> office = officesRepository.findById(id);
        return office;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/offices")
    public Integer postOffice(@RequestBody Offices office) {
        officesRepository.save(office);
        return office.getId();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/offices")
    public String putOffice(@RequestBody Offices newOffice) {
        try {
            Offices office = officesRepository.findById(newOffice.getId()).orElseThrow();
            if (newOffice.getCountry() != null) {
                office.setCountry(newOffice.getCountry());
            }
            if (newOffice.getTitle() != null) {
                office.setTitle(newOffice.getTitle());
            }
            if (newOffice.getPhone() != null) {
                office.setPhone(newOffice.getPhone());
            }
            if (newOffice.getContact() != null) {
                office.setContact(newOffice.getContact());
            }
            officesRepository.save(office);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/offices/{id}")
    public String deleteOffice(
            @PathVariable(value = "id") int id) {
        try {
            Offices office = officesRepository.findById(id).orElseThrow();
            officesRepository.delete(office);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }
}