package hello.Controllers;

import hello.Models.Offices;
import hello.Models.OfficesDTO;
import hello.Repositories.CountriesRepository;
import hello.Repositories.OfficesRepository;
import hello.Response;
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
    public Offices postOffice(@RequestBody OfficesDTO officeDTO) {
        Offices office = new Offices();
        office.setCountry(countriesRepository.findById(officeDTO.getCountry()).orElseThrow());
        office.setTitle(officeDTO.getTitle());
        office.setPhone(officeDTO.getPhone());
        office.setContact(officeDTO.getContact());
        officesRepository.save(office);
        return office;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/offices")
    public Offices putOffice(@RequestBody OfficesDTO officeDTO) {
        try {
            Offices office = officesRepository.findById(officeDTO.getId()).orElseThrow();
            if (officeDTO.getCountry() != null) {
                office.setCountry(countriesRepository.findById(officeDTO.getCountry()).orElseThrow());
            }
            if (officeDTO.getTitle() != null) {
                office.setTitle(officeDTO.getTitle());
            }
            if (officeDTO.getPhone() != null) {
                office.setPhone(officeDTO.getPhone());
            }
            if (officeDTO.getContact() != null) {
                office.setContact(officeDTO.getContact());
            }
            officesRepository.save(office);
            return office;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/offices/{id}")
    public Offices deleteOffice(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            Offices office = officesRepository.findById(id).orElseThrow();
            officesRepository.delete(office);
            return office;
        } catch (Exception e) {
            return null;
        }
    }
}