package hello.Controllers;

import hello.Models.Amenities;
import hello.Repositories.AmenitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AmenitiesController{
    @Autowired
    private AmenitiesRepository amenitiesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/amenities")
    public Iterable<Amenities> getAmenities() {
        return amenitiesRepository.findAll();
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/amenities/{id}")
    public Optional<Amenities> getAmenities(@PathVariable(value = "id") int id) {
        return amenitiesRepository.findById(id);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/amenities")
    public Amenities postAmenities(@RequestBody Amenities amenities) {
        amenitiesRepository.save(amenities);
        return amenities;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @PutMapping("/amenities")
    public Amenities putAmenities(@RequestBody Amenities amenitiesInput) {
        try {
            Amenities amenities = amenitiesRepository.findById(amenitiesInput.getId()).orElseThrow();
            if (amenitiesInput.getService() != null) {
                amenities.setService(amenitiesInput.getService());
            }
            if (amenitiesInput.getPrice() != null) {
                amenities.setPrice(amenitiesInput.getPrice());
            }
            amenitiesRepository.save(amenities);
            return amenities;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @DeleteMapping("/amenities/{id}")
    public Amenities deleteAmenities(@PathVariable(value = "id") int id) {
        try {
            Amenities amenities = amenitiesRepository.findById(id).orElseThrow();
            amenitiesRepository.delete(amenities);
            return amenities;
        } catch (Exception e) {
            return null;
        }
    }
}
