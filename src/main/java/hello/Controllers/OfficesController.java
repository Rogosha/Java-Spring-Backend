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

    @GetMapping("/offices")
    public Iterable<Offices> getOffices() {
        Iterable<Offices> offices = officesRepository.findAll();
        return offices;
    }

    @GetMapping("/offices/{id}")
    public Optional<Offices> getOffice(@PathVariable(value = "id") int id) {
        Optional<Offices> office = officesRepository.findById(id);
        return office;
    }

    @PostMapping("/offices")
    public Integer postOffice(
            @RequestParam(name = "CountryID") Integer countryID,
            @RequestParam(name = "Title") String title,
            @RequestParam(name = "Phone") String phone,
            @RequestParam(name = "Contact") String contact) {

        Offices office = new Offices(countriesRepository.findById(countryID).orElseThrow(), title, phone, contact);
        officesRepository.save(office);
        return office.getId();
    }

    @PutMapping("/offices/{id}")
    public String putOffice(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "CountryID", required = false) Integer countryID,
            @RequestParam(name = "Title", required = false) String title,
            @RequestParam(name = "Phone", required = false) String phone,
            @RequestParam(name = "Contact", required = false) String contact) {
        try {
            Offices office = officesRepository.findById(id).orElseThrow();
            if (countryID == null) {
                countryID = office.getCountry().getId();
            }
            if (title == null) {
                phone = office.getTitle();
            }
            if (phone == null) {
                phone = office.getPhone();
            }
            if (contact == null) {
                contact = office.getContact();
            }
            office.setCountry(countriesRepository.findById(countryID).orElseThrow());
            office.setTitle(title);
            office.setPhone(phone);
            office.setContact(contact);
            officesRepository.save(office);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }

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